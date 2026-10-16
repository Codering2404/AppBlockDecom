package androidx.glance.appwidget;

import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.appwidget.protobuf.GeneratedMessageLite;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.appwidget.LayoutConfiguration$save$2", f = "WidgetLayout.kt", l = {}, m = "invokeSuspend")
final class LayoutConfiguration$save$2 extends SuspendLambda implements Function2<LayoutProto.LayoutConfig, Continuation<? super LayoutProto.LayoutConfig>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f38102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f38103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LayoutConfiguration f38104c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutConfiguration$save$2(LayoutConfiguration layoutConfiguration, Continuation continuation) {
        super(2, continuation);
        this.f38104c = layoutConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LayoutConfiguration$save$2 layoutConfiguration$save$2 = new LayoutConfiguration$save$2(this.f38104c, continuation);
        layoutConfiguration$save$2.f38103b = obj;
        return layoutConfiguration$save$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LayoutProto.LayoutConfig layoutConfig, Continuation continuation) {
        return ((LayoutConfiguration$save$2) create(layoutConfig, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f38102a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        GeneratedMessageLite.Builder builderA = ((LayoutProto.LayoutConfig) this.f38103b).a();
        LayoutConfiguration layoutConfiguration = this.f38104c;
        LayoutProto.LayoutConfig.Builder builder = (LayoutProto.LayoutConfig.Builder) builderA;
        builder.N(builder.M());
        builder.L();
        for (Map.Entry entry : layoutConfiguration.f38092b.entrySet()) {
            LayoutProto.LayoutNode layoutNode = (LayoutProto.LayoutNode) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            if (layoutConfiguration.f38095e.contains(Boxing.d(iIntValue))) {
                LayoutProto.LayoutDefinition.Builder builderY = LayoutProto.LayoutDefinition.Y();
                builderY.K(layoutNode);
                builderY.L(iIntValue);
                builder.K(builderY);
            }
        }
        return builder.build();
    }
}
