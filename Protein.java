package genes;

import java.util.*;
import java.util.stream.Stream;

/**
 * Copyright 2016 Kunal Sheth
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class Protein {

    public static final Map<String, AminoAcid> CODON_AMINO_ACID_MAPPINGS;
    final Stream<AminoAcid> seq;

    public Protein(final MRNA mrna) {
        final Queue<String> codons = new LinkedList<>();
        for (final Iterator<MRNA.Base> i = mrna.seq.iterator(); i.hasNext(); ) {
            final MRNA.Base mrnaBase1, mrnaBase2, mrnaBase3;
            mrnaBase1 = i.next();
            if (!i.hasNext()) break;
            mrnaBase2 = i.next();
            if (!i.hasNext()) break;
            mrnaBase3 = i.next();
            codons.add(mrnaBase1 + " " + mrnaBase2 + " " + mrnaBase3);
        }

        seq = codons.stream().map(CODON_AMINO_ACID_MAPPINGS::get);
    }

    public enum AminoAcid {
        Glycine, Alanine, Valine, Leucine, Isoleucine, Proline, Phenylalanine, Tyrosine, Tryptophan, Serine, Threonine,
        Cysteine, Methionine, Asparagine, Glutamine, Lysine, Arginine, Histidine, Aspartate, Glutamate
    }

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        seq.forEach(i -> {
            builder.append(i);
            builder.append(' ');
        });
        return builder.toString();
    }

    static {
        final HashMap<String, AminoAcid> codonPairings = new HashMap<>();
        codonPairings.put("Guanine Guanine Uracil", AminoAcid.Glycine);
        codonPairings.put("Guanine Guanine Cytosine", AminoAcid.Glycine);
        codonPairings.put("Guanine Guanine Adenine", AminoAcid.Glycine);
        codonPairings.put("Guanine Guanine Guanine", AminoAcid.Glycine);
        codonPairings.put("Guanine Cytosine Uracil", AminoAcid.Alanine);
        codonPairings.put("Guanine Cytosine Cytosine", AminoAcid.Alanine);
        codonPairings.put("Guanine Cytosine Adenine", AminoAcid.Alanine);
        codonPairings.put("Guanine Cytosine Guanine", AminoAcid.Alanine);
        codonPairings.put("Guanine Uracil Uracil", AminoAcid.Valine);
        codonPairings.put("Guanine Uracil Cytosine", AminoAcid.Valine);
        codonPairings.put("Guanine Uracil Adenine", AminoAcid.Valine);
        codonPairings.put("Guanine Uracil Guanine", AminoAcid.Valine);
        codonPairings.put("Uracil Uracil Adenine", AminoAcid.Leucine);
        codonPairings.put("Uracil Uracil Guanine", AminoAcid.Leucine);
        codonPairings.put("Cytosine Uracil Uracil", AminoAcid.Leucine);
        codonPairings.put("Cytosine Uracil Cytosine", AminoAcid.Leucine);
        codonPairings.put("Cytosine Uracil Adenine", AminoAcid.Leucine);
        codonPairings.put("Cytosine Uracil Guanine", AminoAcid.Leucine);
        codonPairings.put("Adenine Uracil Uracil", AminoAcid.Isoleucine);
        codonPairings.put("Adenine Uracil Cytosine", AminoAcid.Isoleucine);
        codonPairings.put("Adenine Uracil Adenine", AminoAcid.Isoleucine);
        codonPairings.put("Cytosine Cytosine Uracil", AminoAcid.Proline);
        codonPairings.put("Cytosine Cytosine Cytosine", AminoAcid.Proline);
        codonPairings.put("Cytosine Cytosine Adenine", AminoAcid.Proline);
        codonPairings.put("Cytosine Cytosine Guanine", AminoAcid.Proline);
        codonPairings.put("Uracil Uracil Uracil", AminoAcid.Phenylalanine);
        codonPairings.put("Uracil Uracil Cytosine", AminoAcid.Phenylalanine);
        codonPairings.put("Uracil Adenine Uracil", AminoAcid.Tyrosine);
        codonPairings.put("Uracil Adenine Cytosine", AminoAcid.Tyrosine);
        codonPairings.put("Uracil Guanine Guanine", AminoAcid.Tryptophan);
        codonPairings.put("Uracil Cytosine Uracil", AminoAcid.Serine);
        codonPairings.put("Uracil Cytosine Cytosine", AminoAcid.Serine);
        codonPairings.put("Uracil Cytosine Adenine", AminoAcid.Serine);
        codonPairings.put("Uracil Cytosine Guanine", AminoAcid.Serine);
        codonPairings.put("Adenine Guanine Uracil", AminoAcid.Serine);
        codonPairings.put("Adenine Guanine Cytosine", AminoAcid.Serine);
        codonPairings.put("Adenine Cytosine Uracil", AminoAcid.Threonine);
        codonPairings.put("Adenine Cytosine Cytosine", AminoAcid.Threonine);
        codonPairings.put("Adenine Cytosine Adenine", AminoAcid.Threonine);
        codonPairings.put("Adenine Cytosine Guanine", AminoAcid.Threonine);
        codonPairings.put("Uracil Guanine Uracil", AminoAcid.Cysteine);
        codonPairings.put("Uracil Guanine Cytosine", AminoAcid.Cysteine);
        codonPairings.put("Adenine Uracil Guanine", AminoAcid.Methionine);
        codonPairings.put("Adenine Adenine Uracil", AminoAcid.Asparagine);
        codonPairings.put("Adenine Adenine Cytosine", AminoAcid.Asparagine);
        codonPairings.put("Cytosine Adenine Adenine", AminoAcid.Glutamine);
        codonPairings.put("Cytosine Adenine Guanine", AminoAcid.Glutamine);
        codonPairings.put("Adenine Adenine Adenine", AminoAcid.Lysine);
        codonPairings.put("Adenine Adenine Guanine", AminoAcid.Lysine);
        codonPairings.put("Cytosine Guanine Uracil", AminoAcid.Arginine);
        codonPairings.put("Cytosine Guanine Cytosine", AminoAcid.Arginine);
        codonPairings.put("Cytosine Guanine Adenine", AminoAcid.Arginine);
        codonPairings.put("Cytosine Guanine Guanine", AminoAcid.Arginine);
        codonPairings.put("Adenine Guanine Adenine", AminoAcid.Arginine);
        codonPairings.put("Adenine Guanine Guanine", AminoAcid.Arginine);
        codonPairings.put("Cytosine Adenine Uracil", AminoAcid.Histidine);
        codonPairings.put("Cytosine Adenine Cytosine", AminoAcid.Histidine);
        codonPairings.put("Guanine Adenine Uracil", AminoAcid.Aspartate);
        codonPairings.put("Guanine Adenine Cytosine", AminoAcid.Aspartate);
        codonPairings.put("Guanine Adenine Adenine", AminoAcid.Glutamate);
        codonPairings.put("Guanine Adenine Guanine", AminoAcid.Glutamate);
        CODON_AMINO_ACID_MAPPINGS = Collections.unmodifiableMap(codonPairings);
    }
}
