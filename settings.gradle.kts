rootProject.name = "bootfx"
include("core")
include("samples")


pluginManagement {
    repositories {
        maven {
            setUrl( "https://oss.sonatype.org/content/repositories/snapshots")
        }
        gradlePluginPortal()
    }
}