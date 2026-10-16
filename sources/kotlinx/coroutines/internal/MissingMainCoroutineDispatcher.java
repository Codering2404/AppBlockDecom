package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f142471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f142472c;

    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable th, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i3 & 2) != 0 ? null : str);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void R0() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f142471b
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f142472c
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f142471b
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.MainDispatchersKt.d()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.MissingMainCoroutineDispatcher.R0():java.lang.Void");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public Void M(CoroutineContext coroutineContext, Runnable runnable) {
        R0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public Void i(long j3, CancellableContinuation cancellableContinuation) {
        R0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean e0(CoroutineContext coroutineContext) {
        R0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher j0(int i3, String str) {
        R0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle m(long j3, Runnable runnable, CoroutineContext coroutineContext) {
        R0();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f142471b != null) {
            str = ", cause=" + this.f142471b;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.f142471b = th;
        this.f142472c = str;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher w0() {
        return this;
    }
}
