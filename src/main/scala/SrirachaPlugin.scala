package sbtsriracha

import sbt._
import java.util.concurrent.atomic.AtomicBoolean

object SrirachaPlugin extends AutoPlugin {
  val sourceMode: AtomicBoolean = new AtomicBoolean(
    java.lang.Boolean.getBoolean("sbt.sourcemode"))
  override val requires = sbt.plugins.JvmPlugin
  override val trigger = allRequirements
  object autoImport {
    lazy val workspaceDirectory: File =
      sys.props.get("sbt.workspace") match {
        case Some(x) => file(x)
        case _       => Path.userHome / "workspace"
      }

    def setSourceMode(b: Boolean): Unit = sourceMode.set(b)
    implicit def sbtsrirachaRichProject(project: Project): RichProject =
      new RichProject(project)
  }
}

class RichProject(val project: Project) {
  def sourceDependency(ref: ClasspathDep[ProjectReference], bin: ModuleID): Project =
    if (SrirachaPlugin.sourceMode.get) project.dependsOn(ref)
    else project.settings(Keys.libraryDependencies += bin)
}
