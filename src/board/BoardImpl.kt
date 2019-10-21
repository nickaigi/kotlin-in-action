package board

import board.Direction.*

open class SquareBoardImpl(override val width: Int) : SquareBoard {
    private val cells = mutableMapOf<Int, List<Cell>>()
    init {

        for (row in 1..width) {
            val rowCells = mutableListOf<Cell>()
            for (column in 1..width) {
                rowCells.add(Cell(row, column))
            }
            cells[row] = rowCells
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        if ((i == 0) || (j == 0) || (i > width) || (j > width))
            return null
        val rowCells = cells[i]
        println("rowCells: $rowCells")
        return rowCells!![j-1]
    }

    override fun getCell(i: Int, j: Int): Cell {

        val rowCells = cells[i]

        return rowCells!![j-1]
    }

    override fun getAllCells(): Collection<Cell> {
        val allCells = mutableListOf<Cell>()

        for ( (_, rowCells) in cells){
            rowCells.forEach { allCells.add(it) }
        }
        println(allCells)
        return allCells
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val rowCells = cells[i]
        val result = mutableListOf<Cell>()
        for (j in jRange) {
            if (j <= width)
                result.add(rowCells!![j - 1])
        }
        return result
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val columnCells = mutableListOf<Cell>()
        for (i in iRange) {
            if (i <= width) {
                val cell = cells[i]!![j - 1]
                columnCells.add(cell)
            }
        }
        return columnCells
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? = when (direction){
        UP -> getCellOrNull(i - 1, j)
        DOWN -> getCellOrNull(i + 1, j)
        RIGHT -> getCellOrNull(i, j + 1)
        LEFT -> getCellOrNull(i, j - 1)
    }
}

class GameBoardImpl<T>(override val width: Int) : GameBoard<T> {
    var board = SquareBoardImpl(width)

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

    override fun get(cell: Cell): T? {
        this.getAllCells()
        TODO()
    }

    override fun set(cell: Cell, value: T?) {
        TODO()
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        TODO()
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        TODO("not implemented")
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        TODO()
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        TODO()
    }

}

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)

