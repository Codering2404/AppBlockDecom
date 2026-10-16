package androidx.glance.appwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1", f = "AppWidgetUtils.kt", l = {255}, m = "provideContent")
final class AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f37782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f37783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f37784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f37785d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AppWidgetUtilsKt$runGlance$1$receiver$1 f37786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f37787g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1(AppWidgetUtilsKt$runGlance$1$receiver$1 appWidgetUtilsKt$runGlance$1$receiver$1, Continuation continuation) {
        super(continuation);
        this.f37786f = appWidgetUtilsKt$runGlance$1$receiver$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f37785d = obj;
        this.f37787g |= Integer.MIN_VALUE;
        return this.f37786f.L(null, this);
    }
}
