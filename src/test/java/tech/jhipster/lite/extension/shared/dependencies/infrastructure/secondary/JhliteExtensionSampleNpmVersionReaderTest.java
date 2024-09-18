package tech.jhipster.lite.extension.shared.dependencies.infrastructure.secondary;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static tech.jhipster.lite.extension.shared.dependencies.domain.JhliteExtensionSampleNpmVersionSource.JHLITE_EXTENSION_SAMPLE;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.jhipster.lite.extension.UnitTest;
import tech.jhipster.lite.module.domain.ProjectFiles;
import tech.jhipster.lite.module.domain.npm.NpmPackageName;
import tech.jhipster.lite.module.domain.npm.NpmPackageVersion;

@UnitTest
@ExtendWith(MockitoExtension.class)
class JhliteExtensionSampleNpmVersionReaderTest {

  @Mock
  private ProjectFiles projectFiles;

  @InjectMocks
  private JhliteExtensionSampleNpmVersionReader reader;

  @Test
  void shouldGetVersionFromCustomSource() {
    mockProjectFiles();

    NpmPackageVersion version = reader.get().get(new NpmPackageName("vue"), JHLITE_EXTENSION_SAMPLE.build());

    assertThat(version).isEqualTo(new NpmPackageVersion("1.2.3"));
  }

  private void mockProjectFiles() {
    when(projectFiles.readString(anyString())).thenReturn(
      """
      {
        "dependencies": {
          "vue": "1.2.3"
        },
      }
      """
    );
  }
}
