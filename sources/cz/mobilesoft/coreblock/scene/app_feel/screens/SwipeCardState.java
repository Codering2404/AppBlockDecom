package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SwipeCardState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f98733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Animatable f98734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableFloatState f98735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableFloatState f98736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableFloatState f98737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f98738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SpringSpec f98739g;

    public SwipeCardState(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f98733a = coroutineScope;
        this.f98734b = AnimatableKt.b(0.0f, 0.0f, 2, null);
        this.f98735c = PrimitiveSnapshotStateKt.a(0.0f);
        this.f98736d = PrimitiveSnapshotStateKt.a(0.0f);
        this.f98737e = PrimitiveSnapshotStateKt.a(0.0f);
        this.f98738f = SnapshotStateKt__SnapshotStateKt.e(Offset.d(Offset.f25596b.c()), null, 2, null);
        this.f98739g = AnimationSpecKt.l(1.0f, 200.0f, null, 4, null);
    }

    public final void a(Function0 onFinish) {
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        BuildersKt__Builders_commonKt.d(this.f98733a, null, null, new SwipeCardState$dismiss$1(this, onFinish, null), 3, null);
    }

    public final Animatable b() {
        return this.f98734b;
    }

    public final float c() {
        return this.f98736d.c();
    }

    public final float d() {
        return this.f98737e.c();
    }

    public final SpringSpec e() {
        return this.f98739g;
    }

    public final float f() {
        return this.f98735c.c();
    }

    public final void g(float f3) {
        this.f98736d.s(f3);
    }

    public final void h(long j3) {
        this.f98738f.setValue(Offset.d(j3));
    }

    public final void i(float f3) {
        this.f98737e.s(f3);
    }

    public final void j(float f3) {
        this.f98735c.s(f3);
    }

    public final void k(Function0 onFinish) {
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        BuildersKt__Builders_commonKt.d(this.f98733a, null, null, new SwipeCardState$swipeLeft$1(this, onFinish, null), 3, null);
    }

    public final void l(Function0 onFinish) {
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        BuildersKt__Builders_commonKt.d(this.f98733a, null, null, new SwipeCardState$swipeRight$1(this, onFinish, null), 3, null);
    }
}
