package parser

import ParseResult
import assert.assert
import assert.assert.AssertionError

abstract class FIParser {
    companion object {
        val stdTypeList = listOf("int", "long", "double")
    }

    abstract fun commonName(): String
    abstract fun check(argsList: List<String>, returnType: String): Boolean
    abstract fun internalParse(argsList: List<String>, returnType: String): ParseResult

    fun parse(argsList: List<String>, returnType: String): ParseResult {
        assert(check(argsList, returnType), AssertionError())
        return internalParse(argsList, returnType)
    }
}