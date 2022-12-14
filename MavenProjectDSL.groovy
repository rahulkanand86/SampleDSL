job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
        git("https://github.com/rahulkanand86/FirstMavenProject.git", 'main')
    }
    triggers {
        scm('H/5 * * * 1-5')
    }
    steps {
        maven('clean package', 'single-module/pom.xml')
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}