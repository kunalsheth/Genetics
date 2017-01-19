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

public class MRNA {

    public static final Map<DNA.Base, Base> DNA_RNA_BASE_MAPPINGS;
    protected final Stream<Base> seq;

    static {
        final Map<DNA.Base, Base> basePairs = new HashMap<>();
        basePairs.put(DNA.Base.Adenine, Base.Uracil);
        basePairs.put(DNA.Base.Thymine, Base.Adenine);
        basePairs.put(DNA.Base.Cytosine, Base.Guanine);
        basePairs.put(DNA.Base.Guanine, Base.Cytosine);
        DNA_RNA_BASE_MAPPINGS = Collections.unmodifiableMap(basePairs);
    }

    public MRNA(final Stream<Base> seq) {
        this.seq = seq;
    }

    public MRNA(final DNA dna) {
        this.seq = dna.seq.map(DNA_RNA_BASE_MAPPINGS::get);
    }

    public enum Base {
        Adenine, Uracil, Cytosine, Guanine
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
