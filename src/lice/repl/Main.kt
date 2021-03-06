package lice.repl

import lice.compiler.parse.createAst
import lice.compiler.util.SymbolList
import lice.compiler.util.serr
import java.io.File
import java.util.*

/**
 * The entrance of the whole application
 * Created by ice1000 on 2017/2/12.
 *
 * @author ice1000
 */

object Main {

	/**
	 * interpret code in a file
	 */
	@JvmOverloads
	fun interpret(
			file: File,
			symbolList: SymbolList = SymbolList()) {
		val ast = createAst(file, symbolList)
		ast.root.eval()
	}

	@JvmStatic
	fun main(args: Array<String>) {
		if (args.isEmpty()) {
			val sl = SymbolList()
			val scanner = Scanner(System.`in`)
			val repl = Repl()
			while (true)
				repl.handle(scanner.nextLine(), sl)
		} else {
			interpret(File(args[0]).apply {
				if (!exists()) serr("file not found: ${args[0]}")
			})
		}
		System.exit(0)
	}
}
