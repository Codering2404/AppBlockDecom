package androidx.compose.material3;

import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ExposedDropdownMenu_androidKt$expandable$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f17687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f17688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f17690d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f17691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f17692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SoftwareKeyboardController f17693h;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.f139807a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (MenuAnchorType.g(this.f17687a, MenuAnchorType.f18132b.c())) {
            SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.a());
            SemanticsPropertiesKt.w0(semanticsPropertyReceiver, this.f17688b ? this.f17689c : this.f17690d);
            SemanticsPropertiesKt.d0(semanticsPropertyReceiver, this.f17691f);
        } else {
            SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.d());
        }
        final Function0 function0 = this.f17692g;
        final String str = this.f17687a;
        final SoftwareKeyboardController softwareKeyboardController = this.f17693h;
        SemanticsPropertiesKt.B(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                SoftwareKeyboardController softwareKeyboardController2;
                function0.invoke();
                if (MenuAnchorType.g(str, MenuAnchorType.f18132b.a()) && (softwareKeyboardController2 = softwareKeyboardController) != null) {
                    softwareKeyboardController2.show();
                }
                return Boolean.TRUE;
            }
        }, 1, null);
    }
}
