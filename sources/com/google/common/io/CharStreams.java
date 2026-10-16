package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class CharStreams {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NullWriter extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final NullWriter f85250a = new NullWriter();

        private NullWriter() {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c3) {
            return this;
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i3) {
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            return this;
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            Preconditions.t(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) {
            Preconditions.y(i3, i4 + i3, cArr.length);
        }

        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.t(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i3, int i4) {
            Preconditions.y(i3, i4 + i3, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i3, int i4) {
            Preconditions.y(i3, i4, charSequence == null ? 4 : charSequence.length());
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
