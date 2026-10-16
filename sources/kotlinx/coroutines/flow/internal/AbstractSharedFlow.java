package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

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
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractSharedFlowSlot[] f142257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f142258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f142259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SubscriptionCountStateFlow f142260d;

    public final StateFlow d() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this.f142260d;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.f142258b);
                this.f142260d = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }

    protected final AbstractSharedFlowSlot h() {
        AbstractSharedFlowSlot abstractSharedFlowSlotI;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            try {
                AbstractSharedFlowSlot[] abstractSharedFlowSlotArrJ = this.f142257a;
                if (abstractSharedFlowSlotArrJ == null) {
                    abstractSharedFlowSlotArrJ = j(2);
                    this.f142257a = abstractSharedFlowSlotArrJ;
                } else if (this.f142258b >= abstractSharedFlowSlotArrJ.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(abstractSharedFlowSlotArrJ, abstractSharedFlowSlotArrJ.length * 2);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    this.f142257a = (AbstractSharedFlowSlot[]) objArrCopyOf;
                    abstractSharedFlowSlotArrJ = (AbstractSharedFlowSlot[]) objArrCopyOf;
                }
                int i3 = this.f142259c;
                do {
                    abstractSharedFlowSlotI = abstractSharedFlowSlotArrJ[i3];
                    if (abstractSharedFlowSlotI == null) {
                        abstractSharedFlowSlotI = i();
                        abstractSharedFlowSlotArrJ[i3] = abstractSharedFlowSlotI;
                    }
                    i3++;
                    if (i3 >= abstractSharedFlowSlotArrJ.length) {
                        i3 = 0;
                    }
                    Intrinsics.checkNotNull(abstractSharedFlowSlotI, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!abstractSharedFlowSlotI.a(this));
                this.f142259c = i3;
                this.f142258b++;
                subscriptionCountStateFlow = this.f142260d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.Z(1);
        }
        return abstractSharedFlowSlotI;
    }

    protected abstract AbstractSharedFlowSlot i();

    protected abstract AbstractSharedFlowSlot[] j(int i3);

    protected final void k(AbstractSharedFlowSlot abstractSharedFlowSlot) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i3;
        Continuation[] continuationArrB;
        synchronized (this) {
            try {
                int i4 = this.f142258b - 1;
                this.f142258b = i4;
                subscriptionCountStateFlow = this.f142260d;
                if (i4 == 0) {
                    this.f142259c = 0;
                }
                Intrinsics.checkNotNull(abstractSharedFlowSlot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                continuationArrB = abstractSharedFlowSlot.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrB) {
            if (continuation != null) {
                Result.Companion companion = Result.f139772b;
                continuation.resumeWith(Result.b(Unit.f139807a));
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.Z(-1);
        }
    }

    protected final int l() {
        return this.f142258b;
    }

    protected final AbstractSharedFlowSlot[] m() {
        return this.f142257a;
    }
}
