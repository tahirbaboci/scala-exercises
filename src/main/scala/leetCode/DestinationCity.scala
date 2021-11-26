package leetCode

object DestinationCity extends App{

  def destCity(paths: List[List[String]]): String = {
    val pathsInMap = convertToMap(paths, Map.empty)
    tailRecFindDest(paths, pathsInMap, "", paths.head.last)
  }

  def convertToMap(paths: List[List[String]], acc: Map[String, String]): Map[String, String] = {
    paths match {
      case Nil => acc
      case h::tail => convertToMap(tail, acc + (h.head -> h(1)))
    }
  }
  def tailRecFindDest(paths: List[List[String]], mapPaths: Map[String, String], location: String, accDestination: String): String = {
    paths match {
      case Nil => accDestination
      case h::tail if mapPaths.keySet.contains(accDestination) =>
        tailRecFindDest(tail, mapPaths, h.head, mapPaths.getOrElse(h.head, "NoDestination"))
      case h::tail => tailRecFindDest(tail, mapPaths, h.head, accDestination)
    }
  }
}
