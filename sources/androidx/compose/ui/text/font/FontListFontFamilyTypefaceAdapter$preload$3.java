package androidx.compose.ui.text.font;

import androidx.collection.MutableScatterSet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3", f = "FontListFontFamilyTypefaceAdapter.kt", l = {120}, m = "invokeSuspend")
final class FontListFontFamilyTypefaceAdapter$preload$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f29189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f29190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f29191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FontListFontFamilyTypefaceAdapter f29192d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PlatformFontLoader f29193f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontListFontFamilyTypefaceAdapter$preload$3(List list, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontLoader platformFontLoader, Continuation continuation) {
        super(2, continuation);
        this.f29191c = list;
        this.f29192d = fontListFontFamilyTypefaceAdapter;
        this.f29193f = platformFontLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FontListFontFamilyTypefaceAdapter$preload$3 fontListFontFamilyTypefaceAdapter$preload$3 = new FontListFontFamilyTypefaceAdapter$preload$3(this.f29191c, this.f29192d, this.f29193f, continuation);
        fontListFontFamilyTypefaceAdapter$preload$3.f29190b = obj;
        return fontListFontFamilyTypefaceAdapter$preload$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f29189a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f29190b;
            List list = this.f29191c;
            MutableScatterSet mutableScatterSet = new MutableScatterSet(list.size());
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj2 = list.get(i4);
                if (mutableScatterSet.i((Font) obj2)) {
                    arrayList.add(obj2);
                }
            }
            FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.f29192d;
            PlatformFontLoader platformFontLoader = this.f29193f;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i5 = 0; i5 < size2; i5++) {
                arrayList2.add(BuildersKt__Builders_commonKt.b(coroutineScope, null, null, new FontListFontFamilyTypefaceAdapter$preload$3$2$1(fontListFontFamilyTypefaceAdapter, (Font) arrayList.get(i5), platformFontLoader, null), 3, null));
            }
            this.f29189a = 1;
            if (AwaitKt.c(arrayList2, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FontListFontFamilyTypefaceAdapter$preload$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
