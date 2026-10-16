package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Streams {
    public static JsonElement a(JsonReader jsonReader) {
        boolean z2;
        try {
            try {
                jsonReader.j0();
                z2 = false;
            } catch (EOFException e3) {
                e = e3;
                z2 = true;
            }
            try {
                return (JsonElement) TypeAdapters.V.b(jsonReader);
            } catch (EOFException e4) {
                e = e4;
                if (z2) {
                    return JsonNull.f90293a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e5) {
            throw new JsonSyntaxException(e5);
        } catch (IOException e6) {
            throw new JsonIOException(e6);
        } catch (NumberFormatException e7) {
            throw new JsonSyntaxException(e7);
        }
    }

    public static void b(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.V.d(jsonWriter, jsonElement);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AppendableWriter extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f90386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CurrentWrite f90387b = new CurrentWrite();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class CurrentWrite implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private char[] f90388a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f90389b;

            private CurrentWrite() {
            }

            void a(char[] cArr) {
                this.f90388a = cArr;
                this.f90389b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i3) {
                return this.f90388a[i3];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f90388a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i3, int i4) {
                return new String(this.f90388a, i3, i4 - i3);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f90389b == null) {
                    this.f90389b = new String(this.f90388a);
                }
                return this.f90389b;
            }
        }

        AppendableWriter(Appendable appendable) {
            this.f90386a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i4) throws IOException {
            this.f90387b.a(cArr);
            this.f90386a.append(this.f90387b, i3, i4 + i3);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f90386a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i3) throws IOException {
            this.f90386a.append((char) i3);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i3, int i4) throws IOException {
            this.f90386a.append(charSequence, i3, i4);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i3, int i4) throws IOException {
            Objects.requireNonNull(str);
            this.f90386a.append(str, i3, i4 + i3);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
