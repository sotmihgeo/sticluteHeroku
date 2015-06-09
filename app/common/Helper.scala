package common

case class Pagina[A](elemente: Seq[A], paginaCurenta: Int, nrElemente: Int, nrTotalElemente: Int){
  lazy val prev = Option(paginaCurenta - 1).filter(_ >= 0)
  lazy val next = Option(paginaCurenta + 1).filter(_ => (nrElemente + elemente.size) < nrTotalElemente)
}