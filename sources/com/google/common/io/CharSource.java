package com.google.common.io;

import com.facebook.internal.Utility;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class CharSource {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AsByteSource extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Charset f85243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSource f85244b;

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return new ReaderInputStream(this.f85244b.a(), this.f85243a, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }

        public String toString() {
            return this.f85244b.toString() + ".asByteSource(" + this.f85243a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CharSequenceCharSource extends CharSource {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Splitter f85245b = Splitter.i("\r\n|\n|\r");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final CharSequence f85246a;

        /* JADX INFO: renamed from: com.google.common.io.CharSource$CharSequenceCharSource$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends AbstractIterator<String> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Iterator f85247c;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public String a() {
                if (this.f85247c.hasNext()) {
                    String str = (String) this.f85247c.next();
                    if (this.f85247c.hasNext() || !str.isEmpty()) {
                        return str;
                    }
                }
                return (String) b();
            }
        }

        protected CharSequenceCharSource(CharSequence charSequence) {
            this.f85246a = (CharSequence) Preconditions.t(charSequence);
        }

        @Override // com.google.common.io.CharSource
        public Reader a() {
            return new CharSequenceReader(this.f85246a);
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.h(this.f85246a, 30, "...") + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ConcatenatedCharSource extends CharSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterable f85248a;

        @Override // com.google.common.io.CharSource
        public Reader a() {
            return new MultiReader(this.f85248a.iterator());
        }

        public String toString() {
            return "CharSource.concat(" + this.f85248a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EmptyCharSource extends StringCharSource {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final EmptyCharSource f85249c = new EmptyCharSource();

        private EmptyCharSource() {
            super("");
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public String toString() {
            return "CharSource.empty()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class StringCharSource extends CharSequenceCharSource {
        protected StringCharSource(String str) {
            super(str);
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource, com.google.common.io.CharSource
        public Reader a() {
            return new StringReader((String) this.f85246a);
        }
    }

    protected CharSource() {
    }

    public abstract Reader a();
}
