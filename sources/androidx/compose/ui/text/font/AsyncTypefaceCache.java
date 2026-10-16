package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AsyncTypefaceCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f29131a = AsyncTypefaceResult.b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LruCache f29132b = new LruCache(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableScatterMap f29133c = ScatterMapKt.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SynchronizedObject f29134d = new SynchronizedObject();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Font f29136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f29137b;

        public Key(Font font, Object obj) {
            this.f29136a = font;
            this.f29137b = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual(this.f29136a, key.f29136a) && Intrinsics.areEqual(this.f29137b, key.f29137b);
        }

        public int hashCode() {
            int iHashCode = this.f29136a.hashCode() * 31;
            Object obj = this.f29137b;
            return iHashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "Key(font=" + this.f29136a + ", loaderKey=" + this.f29137b + ')';
        }
    }

    public static /* synthetic */ void f(AsyncTypefaceCache asyncTypefaceCache, Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z2, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        asyncTypefaceCache.e(font, platformFontLoader, obj, z2);
    }

    public final AsyncTypefaceResult d(Font font, PlatformFontLoader platformFontLoader) {
        AsyncTypefaceResult asyncTypefaceResult;
        Key key = new Key(font, platformFontLoader.a());
        synchronized (this.f29134d) {
            asyncTypefaceResult = (AsyncTypefaceResult) this.f29132b.get(key);
            if (asyncTypefaceResult == null) {
                asyncTypefaceResult = (AsyncTypefaceResult) this.f29133c.e(key);
            }
        }
        return asyncTypefaceResult;
    }

    public final void e(Font font, PlatformFontLoader platformFontLoader, Object obj, boolean z2) {
        Key key = new Key(font, platformFontLoader.a());
        synchronized (this.f29134d) {
            try {
                if (obj == null) {
                    this.f29133c.x(key, AsyncTypefaceResult.a(this.f29131a));
                    Unit unit = Unit.f139807a;
                } else if (z2) {
                    this.f29133c.x(key, AsyncTypefaceResult.a(AsyncTypefaceResult.b(obj)));
                    Unit unit2 = Unit.f139807a;
                } else {
                    this.f29132b.put(key, AsyncTypefaceResult.a(AsyncTypefaceResult.b(obj)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(androidx.compose.ui.text.font.Font r5, androidx.compose.ui.text.font.PlatformFontLoader r6, boolean r7, kotlin.jvm.functions.Function1 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = (androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1) r0
            int r1 = r0.f29143g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29143g = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1 r0 = new androidx.compose.ui.text.font.AsyncTypefaceCache$runCached$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.f29141d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f29143g
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            boolean r7 = r0.f29140c
            java.lang.Object r5 = r0.f29139b
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r5 = (androidx.compose.ui.text.font.AsyncTypefaceCache.Key) r5
            java.lang.Object r6 = r0.f29138a
            androidx.compose.ui.text.font.AsyncTypefaceCache r6 = (androidx.compose.ui.text.font.AsyncTypefaceCache) r6
            kotlin.ResultKt.b(r9)
            goto L7d
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.b(r9)
            androidx.compose.ui.text.font.AsyncTypefaceCache$Key r9 = new androidx.compose.ui.text.font.AsyncTypefaceCache$Key
            java.lang.Object r6 = r6.a()
            r9.<init>(r5, r6)
            androidx.compose.ui.text.platform.SynchronizedObject r5 = r4.f29134d
            monitor-enter(r5)
            androidx.collection.LruCache r6 = r4.f29132b     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r6 = r6.get(r9)     // Catch: java.lang.Throwable -> L5d
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r6 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r6     // Catch: java.lang.Throwable -> L5d
            if (r6 != 0) goto L5f
            androidx.collection.MutableScatterMap r6 = r4.f29133c     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r6 = r6.e(r9)     // Catch: java.lang.Throwable -> L5d
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r6 = (androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult) r6     // Catch: java.lang.Throwable -> L5d
            goto L5f
        L5d:
            r6 = move-exception
            goto Lb3
        L5f:
            if (r6 == 0) goto L67
            java.lang.Object r6 = r6.g()     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r5)
            return r6
        L67:
            kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r5)
            r0.f29138a = r4
            r0.f29139b = r9
            r0.f29140c = r7
            r0.f29143g = r3
            java.lang.Object r5 = r8.invoke(r0)
            if (r5 != r1) goto L79
            return r1
        L79:
            r6 = r9
            r9 = r5
            r5 = r6
            r6 = r4
        L7d:
            androidx.compose.ui.text.platform.SynchronizedObject r8 = r6.f29134d
            monitor-enter(r8)
            if (r9 != 0) goto L90
            androidx.collection.MutableScatterMap r7 = r6.f29133c     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r6 = r6.f29131a     // Catch: java.lang.Throwable -> L8e
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r6 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.a(r6)     // Catch: java.lang.Throwable -> L8e
            r7.x(r5, r6)     // Catch: java.lang.Throwable -> L8e
            goto Lad
        L8e:
            r5 = move-exception
            goto Lb1
        L90:
            if (r7 == 0) goto La0
            androidx.collection.MutableScatterMap r6 = r6.f29133c     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r7 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.b(r9)     // Catch: java.lang.Throwable -> L8e
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.a(r7)     // Catch: java.lang.Throwable -> L8e
            r6.x(r5, r7)     // Catch: java.lang.Throwable -> L8e
            goto Lad
        La0:
            androidx.collection.LruCache r6 = r6.f29132b     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r7 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.b(r9)     // Catch: java.lang.Throwable -> L8e
            androidx.compose.ui.text.font.AsyncTypefaceCache$AsyncTypefaceResult r7 = androidx.compose.ui.text.font.AsyncTypefaceCache.AsyncTypefaceResult.a(r7)     // Catch: java.lang.Throwable -> L8e
            r6.put(r5, r7)     // Catch: java.lang.Throwable -> L8e
        Lad:
            kotlin.Unit r5 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L8e
            monitor-exit(r8)
            return r9
        Lb1:
            monitor-exit(r8)
            throw r5
        Lb3:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncTypefaceCache.g(androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.PlatformFontLoader, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class AsyncTypefaceResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f29135a;

        private /* synthetic */ AsyncTypefaceResult(Object obj) {
            this.f29135a = obj;
        }

        public static final /* synthetic */ AsyncTypefaceResult a(Object obj) {
            return new AsyncTypefaceResult(obj);
        }

        public static boolean c(Object obj, Object obj2) {
            return (obj2 instanceof AsyncTypefaceResult) && Intrinsics.areEqual(obj, ((AsyncTypefaceResult) obj2).g());
        }

        public static int d(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public static final boolean e(Object obj) {
            return obj == null;
        }

        public static String f(Object obj) {
            return "AsyncTypefaceResult(result=" + obj + ')';
        }

        public boolean equals(Object obj) {
            return c(this.f29135a, obj);
        }

        public final /* synthetic */ Object g() {
            return this.f29135a;
        }

        public int hashCode() {
            return d(this.f29135a);
        }

        public String toString() {
            return f(this.f29135a);
        }

        public static Object b(Object obj) {
            return obj;
        }
    }
}
