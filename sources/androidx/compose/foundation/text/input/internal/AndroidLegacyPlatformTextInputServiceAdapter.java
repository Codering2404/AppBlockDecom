package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
public final class AndroidLegacyPlatformTextInputServiceAdapter extends LegacyPlatformTextInputServiceAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Job f10177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LegacyTextInputMethodRequest f10178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableSharedFlow f10179d;

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableSharedFlow p() {
        MutableSharedFlow mutableSharedFlow = this.f10179d;
        if (mutableSharedFlow != null) {
            return mutableSharedFlow;
        }
        if (!StylusHandwriting_androidKt.a()) {
            return null;
        }
        MutableSharedFlow mutableSharedFlowB = SharedFlowKt.b(1, 0, BufferOverflow.f141064c, 2, null);
        this.f10179d = mutableSharedFlowB;
        return mutableSharedFlowB;
    }

    private final void q(Function1 function1) {
        LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNodeI = i();
        if (legacyPlatformTextInputNodeI == null) {
            return;
        }
        this.f10177b = legacyPlatformTextInputNodeI.g1(new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2(function1, this, legacyPlatformTextInputNodeI, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, float[] fArr) {
        LayoutCoordinates layoutCoordinatesZ = legacyPlatformTextInputNode.z();
        if (layoutCoordinatesZ != null) {
            if (!layoutCoordinatesZ.m()) {
                layoutCoordinatesZ = null;
            }
            if (layoutCoordinatesZ == null) {
                return;
            }
            layoutCoordinatesZ.i0(fArr);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void a() {
        q(null);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void b() {
        Job job = this.f10177b;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f10177b = null;
        MutableSharedFlow mutableSharedFlowP = p();
        if (mutableSharedFlowP != null) {
            mutableSharedFlowP.e();
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void d(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.f10178c;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.m(textFieldValue, textFieldValue2);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void f(final TextFieldValue textFieldValue, final ImeOptions imeOptions, final Function1 function1, final Function1 function12) {
        q(new Function1<LegacyTextInputMethodRequest, Unit>() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(LegacyTextInputMethodRequest legacyTextInputMethodRequest) {
                legacyTextInputMethodRequest.l(textFieldValue, this.i(), imeOptions, function1, function12);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((LegacyTextInputMethodRequest) obj);
                return Unit.f139807a;
            }
        });
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void g(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1 function1, Rect rect, Rect rect2) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.f10178c;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.n(textFieldValue, offsetMapping, textLayoutResult, rect, rect2);
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void h(Rect rect) {
        LegacyTextInputMethodRequest legacyTextInputMethodRequest = this.f10178c;
        if (legacyTextInputMethodRequest != null) {
            legacyTextInputMethodRequest.j(rect);
        }
    }

    @Override // androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter
    public void k() {
        MutableSharedFlow mutableSharedFlowP = p();
        if (mutableSharedFlowP != null) {
            mutableSharedFlowP.c(Unit.f139807a);
        }
    }
}
