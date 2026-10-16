package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class OnBackInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Channel f465b = ChannelKt.b(-2, BufferOverflow.f141062a, null, 4, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Job f466c;

    public OnBackInstance(CoroutineScope coroutineScope, boolean z2, Function2 function2, OnBackPressedCallback onBackPressedCallback) {
        this.f464a = z2;
        this.f466c = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new OnBackInstance$job$1(onBackPressedCallback, function2, this, null), 3, null);
    }

    public final void a() {
        this.f465b.cancel(new CancellationException("onBack cancelled"));
        Job.DefaultImpls.b(this.f466c, null, 1, null);
    }

    public final boolean b() {
        return SendChannel.DefaultImpls.a(this.f465b, null, 1, null);
    }

    public final Channel c() {
        return this.f465b;
    }

    public final boolean d() {
        return this.f464a;
    }

    public final Object e(BackEventCompat backEventCompat) {
        return this.f465b.h(backEventCompat);
    }

    public final void f(boolean z2) {
        this.f464a = z2;
    }
}
