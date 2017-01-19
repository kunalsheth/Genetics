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

public class DNA {

    public static final Map<Base, Base> DNA_BASE_MAPPINGS;
    protected final Stream<Base> seq;

    static {
        final Map<Base, Base> basePairs = new HashMap<>();
        basePairs.put(Base.Adenine, Base.Thymine);
        basePairs.put(Base.Cytosine, Base.Guanine);
        basePairs.put(Base.Thymine, Base.Adenine);
        basePairs.put(Base.Guanine, Base.Cytosine);
        DNA_BASE_MAPPINGS = Collections.unmodifiableMap(basePairs);
    }

    public static DNA from(final String seq, final boolean isAntisense) {
        final char[] chars = seq.toUpperCase().toCharArray();
        final Queue<Base> bases = new LinkedList<>();
        for (final char baseLetter : chars) {
            if (baseLetter == 'A') bases.add(Base.Adenine);
            else if (baseLetter == 'T') bases.add(Base.Thymine);
            else if (baseLetter == 'C') bases.add(Base.Cytosine);
            else if (baseLetter == 'G') bases.add(Base.Guanine);
            else throw new InputMismatchException("Base letter '" + baseLetter + "' is not defined.");
        }
        return new DNA(bases.stream(), isAntisense);
    }

    public DNA(final Stream<Base> seq, final boolean isAntisense) {
        if (isAntisense) this.seq = seq;
        else this.seq = seq.map(DNA_BASE_MAPPINGS::get);
    }

    public enum Base {
        Adenine, Thymine, Cytosine, Guanine
    }

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        seq.forEach(i -> {
            builder.append(i);
            builder.append(' ');
        });
        return builder.toString();
    }
}
