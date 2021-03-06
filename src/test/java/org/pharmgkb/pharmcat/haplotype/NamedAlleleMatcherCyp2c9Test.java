package org.pharmgkb.pharmcat.haplotype;

import java.nio.file.Path;
import java.util.List;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.pharmgkb.common.util.PathUtils;
import org.pharmgkb.pharmcat.haplotype.model.Result;

import static org.pharmgkb.pharmcat.haplotype.NamedAlleleMatcherTest.assertDiplotypePairs;
import static org.pharmgkb.pharmcat.haplotype.NamedAlleleMatcherTest.testMatchNamedAlleles;


/**
 * JUnit test for {@link NamedAlleleMatcher#callDiplotypes(MatchData)}.
 *
 * @author Lester Carter
 */
public class NamedAlleleMatcherCyp2c9Test {
  private Path m_definitionFile;

  @Before
  public void before() throws Exception {
    m_definitionFile =  PathUtils.getPathToResource("org/pharmgkb/pharmcat/haplotype/CYP2C9_translation.json");
  }

  @Test
  public void cyp32c9s1s1() throws Exception {
    // Test *1/*1

    Path vcfFile = PathUtils.getPathToResource("org/pharmgkb/pharmcat/haplotype/cyp2c9/s1s1.vcf");
    List<String> expectedMatches = Lists.newArrayList("*1/*1");

    Result result = testMatchNamedAlleles(m_definitionFile, vcfFile);
    assertDiplotypePairs(expectedMatches, result);
  }

  @Test
  public void cyp32c9s2s3() throws Exception {
    // Test *2/*3

    Path vcfFile = PathUtils.getPathToResource("org/pharmgkb/pharmcat/haplotype/cyp2c9/s2s3.vcf");
    List<String> expectedMatches = Lists.newArrayList("*2/*3");

    Result result = testMatchNamedAlleles(m_definitionFile, vcfFile);
    assertDiplotypePairs(expectedMatches, result);
  }

  @Test
  public void cyp32c9s2s24() throws Exception {
    // Test *2/*24, but also matches *1/*24

    Path vcfFile = PathUtils.getPathToResource("org/pharmgkb/pharmcat/haplotype/cyp2c9/s2s24.vcf");
    List<String> expectedMatches = Lists.newArrayList("*1/*24", "*2/*24");

    Result result = testMatchNamedAlleles(m_definitionFile, vcfFile);
    assertDiplotypePairs(expectedMatches, result);
  }

  @Test
  public void cyp32c9s2s24Only() throws Exception {
    // Test *2/*24, but also matches *1/*24

    Path vcfFile = PathUtils.getPathToResource("org/pharmgkb/pharmcat/haplotype/cyp2c9/s2s24only.vcf");
    List<String> expectedMatches = Lists.newArrayList("*2/*24");

    Result result = testMatchNamedAlleles(m_definitionFile, vcfFile);
    assertDiplotypePairs(expectedMatches, result);
  }

  @Test
  public void cyp32c9s24s24() throws Exception {
    // Test *24/*24 with hom at rs749060448

    Path vcfFile = PathUtils.getPathToResource("org/pharmgkb/pharmcat/haplotype/cyp2c9/s24s24.vcf");
    List<String> expectedMatches = Lists.newArrayList("*24/*24");

    Result result = testMatchNamedAlleles(m_definitionFile, vcfFile);
    assertDiplotypePairs(expectedMatches, result);
  }

  @Test
  public void cyp32c9s2s25() throws Exception {
    // Test *2/*25

    Path vcfFile = PathUtils.getPathToResource("org/pharmgkb/pharmcat/haplotype/cyp2c9/s2s25.vcf");
    List<String> expectedMatches = Lists.newArrayList("*2/*25");

    Result result = testMatchNamedAlleles(m_definitionFile, vcfFile);
    assertDiplotypePairs(expectedMatches, result);
  }
}
