package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonReader f90296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f90297b;

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonElement next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.a(this.f90296a);
        } catch (OutOfMemoryError e3) {
            throw new JsonParseException("Failed parsing JSON source to Json", e3);
        } catch (StackOverflowError e4) {
            throw new JsonParseException("Failed parsing JSON source to Json", e4);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z2;
        synchronized (this.f90297b) {
            try {
                try {
                    try {
                        z2 = this.f90296a.j0() != JsonToken.END_DOCUMENT;
                    } catch (IOException e3) {
                        throw new JsonIOException(e3);
                    }
                } catch (MalformedJsonException e4) {
                    throw new JsonSyntaxException(e4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
