package board

import board.Direction.*

open class SquareBoardImpl(override val width: Int) : SquareBoard {
    override fun getCellOrNull(i: Int, j: Int): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCell(i: Int, j: Int): Cell {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllCells(): Collection<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class GameBoardImpl<T>(override val width: Int) : SquareBoardImpl(width), GameBoard<T> {
    override fun get(cell: Cell): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(cell: Cell, value: T?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun createSquareBoard(width: Int): SquareBoard = TODO()
fun <T> createGameBoard(width: Int): GameBoard<T> = TODO()

