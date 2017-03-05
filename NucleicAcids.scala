package genes

object NucleicAcids {

  object DNA extends Enumeration {
    type DnaBase = Value
    val Adenine, Thymine, Cytosine, Guanine = Value

    val baseInitials: Map[Char, DnaBase] = Map(
      'A' -> Adenine,
      'T' -> Thymine,
      'C' -> Cytosine,
      'G' -> Guanine
    ).withDefaultValue(null)

    val replication: Map[DnaBase, DnaBase] = Map(
      Thymine -> Adenine,
      Adenine -> Thymine,
      Guanine -> Cytosine,
      Cytosine -> Guanine
    ).withDefaultValue(null)
  }

  object MRNA extends Enumeration {
    type RnaBase = Value
    val Adenine, Uracil, Cytosine, Guanine = Value

    val baseInitials: Map[Char, RnaBase] = Map(
      'A' -> Adenine,
      'U' -> Uracil,
      'C' -> Cytosine,
      'G' -> Guanine
    ).withDefaultValue(null)

    val transcription: Map[DNA.DnaBase, RnaBase] = Map(
      DNA.Thymine -> Adenine,
      DNA.Adenine -> Uracil,
      DNA.Guanine -> Cytosine,
      DNA.Cytosine -> Guanine
    ).withDefaultValue(null)
  }
}
