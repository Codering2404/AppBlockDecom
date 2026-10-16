package androidx.compose.ui.focus;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class FocusPropertiesImpl implements FocusProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f25503a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FocusRequester f25504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FocusRequester f25505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FocusRequester f25506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FocusRequester f25507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FocusRequester f25508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FocusRequester f25509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FocusRequester f25510h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FocusRequester f25511i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Function1 f25512j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Function1 f25513k;

    public FocusPropertiesImpl() {
        FocusRequester.Companion companion = FocusRequester.f25519b;
        this.f25504b = companion.b();
        this.f25505c = companion.b();
        this.f25506d = companion.b();
        this.f25507e = companion.b();
        this.f25508f = companion.b();
        this.f25509g = companion.b();
        this.f25510h = companion.b();
        this.f25511i = companion.b();
        this.f25512j = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$onEnter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((FocusEnterExitScope) obj);
                return Unit.f139807a;
            }

            public final void c(FocusEnterExitScope focusEnterExitScope) {
            }
        };
        this.f25513k = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesImpl$onExit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((FocusEnterExitScope) obj);
                return Unit.f139807a;
            }

            public final void c(FocusEnterExitScope focusEnterExitScope) {
            }
        };
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester a() {
        return this.f25510h;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester b() {
        return this.f25504b;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester m() {
        return this.f25508f;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester p() {
        return this.f25509g;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester q() {
        return this.f25506d;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester r() {
        return this.f25511i;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester s() {
        return this.f25507e;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void t(boolean z2) {
        this.f25503a = z2;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void u(Function1 function1) {
        this.f25512j = function1;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean v() {
        return this.f25503a;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public FocusRequester w() {
        return this.f25505c;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public Function1 x() {
        return this.f25512j;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public Function1 y() {
        return this.f25513k;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void z(Function1 function1) {
        this.f25513k = function1;
    }
}
