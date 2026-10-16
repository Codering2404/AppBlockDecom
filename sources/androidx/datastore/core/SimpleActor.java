package androidx.datastore.core;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;

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
public final class SimpleActor<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f35801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f35802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Channel f35803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInt f35804d;

    public SimpleActor(CoroutineScope scope, final Function1 onComplete, final Function2 onUndeliveredElement, Function2 consumeMessage) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Intrinsics.checkNotNullParameter(onUndeliveredElement, "onUndeliveredElement");
        Intrinsics.checkNotNullParameter(consumeMessage, "consumeMessage");
        this.f35801a = scope;
        this.f35802b = consumeMessage;
        this.f35803c = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);
        this.f35804d = new AtomicInt(0);
        Job job = (Job) scope.getCoroutineContext().get(Job.v8);
        if (job != null) {
            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.datastore.core.SimpleActor.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Throwable th) {
                    Unit unit;
                    onComplete.invoke(th);
                    this.f35803c.w(th);
                    do {
                        Object objF = ChannelResult.f(this.f35803c.s());
                        if (objF != null) {
                            onUndeliveredElement.invoke(objF, th);
                            unit = Unit.f139807a;
                        } else {
                            unit = null;
                        }
                    } while (unit != null);
                }
            });
        }
    }

    public final void e(Object obj) throws Throwable {
        Object objH = this.f35803c.h(obj);
        if (objH instanceof ChannelResult.Closed) {
            Throwable thE = ChannelResult.e(objH);
            if (thE != null) {
                throw thE;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!ChannelResult.k(objH)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f35804d.c() == 0) {
            BuildersKt__Builders_commonKt.d(this.f35801a, null, null, new SimpleActor$offer$2(this, null), 3, null);
        }
    }
}
