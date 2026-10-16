package cz.mobilesoft.coreblock.scene.strictmode3;

import androidx.compose.material3.TooltipState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final /* synthetic */ class StrictMode3OverviewKt$Footer$1$1$3$1$1$1 extends FunctionReferenceImpl implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f121109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f121110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f121111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f121112d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TooltipState f121113f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3OverviewKt$Footer$1$1$3$1$1$1(boolean z2, Function1 function1, boolean z3, CoroutineScope coroutineScope, TooltipState tooltipState) {
        super(0, Intrinsics.Kotlin.class, "handleSelectedAccessMethodActionClick", "Footer$lambda$0$0$handleSelectedAccessMethodActionClick(ZLkotlin/jvm/functions/Function1;ZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/material3/TooltipState;)V", 0);
        this.f121109a = z2;
        this.f121110b = function1;
        this.f121111c = z3;
        this.f121112d = coroutineScope;
        this.f121113f = tooltipState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m1371invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1371invoke() {
        StrictMode3OverviewKt.w0(this.f121109a, this.f121110b, this.f121111c, this.f121112d, this.f121113f);
    }
}
