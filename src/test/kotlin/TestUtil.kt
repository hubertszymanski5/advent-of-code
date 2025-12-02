import java.nio.file.Files
import java.nio.file.Paths

fun readTestFile(year: Int, fileName: String): List<String> = Files.lines(getPath(year, fileName)).toList()

private fun getPath(year: Int, fileName: String) = Paths.get("src/test/resources/y$year/$fileName")
