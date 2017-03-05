package genes

import genes.NucleicAcids.DNA._
import genes.NucleicAcids.MRNA._
import genes.Proteins._

object GeneticCode {

  def flipSense(dna: DNA): DNA = DNA(dna.code map replication)

  implicit def transcribe(dna: DNA): MRNA = MRNA(dna.code map transcription)

  implicit def unTranscribe(mrna: MRNA): DNA = DNA(mrna.code map invert(transcription))

  implicit def translate(mrna: MRNA): Protien = Protien(
    mrna.code
      grouped 3
      filter (_.length == 3)
      map (s => (s(0), s(1), s(2)))
      map translation
      toSeq
  )

  implicit def unTranslate(protien: Protien): MRNA = MRNA(
    protien.code
      map invert(translation)
      filter (_ != null)
      flatMap (t => List(t._1, t._2, t._3))
  )

  def invert[A, B](map: Map[A, B]): Map[B, A] = map.map(_.swap)

  case class DNA(code: Seq[DnaBase]) {

    def flipSense(): DNA = GeneticCode flipSense this

    def transcribe(): MRNA = this

    override def toString: String = "DNA: " + code.toList.toString
  }

  case class MRNA(code: Seq[RnaBase]) {

    def unTranscribe(): DNA = this

    def translate(): Protien = this

    override def toString: String = "MRNA: " + code.toList.toString
  }

  case class Protien(code: Seq[AminoAcid]) {

    def unTranslate(): MRNA = this

    override def toString: String = "Protien: " + code.toList.toString
  }

}
