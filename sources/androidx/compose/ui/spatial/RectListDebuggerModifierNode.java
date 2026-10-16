package androidx.compose.ui.spatial;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
final class RectListDebuggerModifierNode extends Modifier.Node implements DrawModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f28574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f28575b;

    public RectListDebuggerModifierNode() {
        androidx.compose.ui.graphics.Paint paintA = AndroidPaint_androidKt.a();
        paintA.u(Color.f25715b.i());
        paintA.E(PaintingStyle.f25822b.b());
        this.f28574a = paintA.y();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        RectList rectListE = DelegatableNodeKt.p(this).getRectManager().e();
        Canvas canvasD = AndroidCanvas_androidKt.d(contentDrawScope.Q1().g());
        Paint paint = this.f28574a;
        long[] jArr = rectListE.f28570a;
        int i3 = rectListE.f28572c;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            long j3 = jArr[i4];
            long j4 = jArr[i4 + 1];
            long j5 = jArr[i4 + 2];
            canvasD.drawRect((int) (j3 >> 32), (int) j3, (int) (j4 >> 32), (int) j4, paint);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.f28575b = DelegatableNodeKt.p(this).getRectManager().o(new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectListDebuggerModifierNode.onAttach.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m258invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m258invoke() {
                DrawModifierNodeKt.a(RectListDebuggerModifierNode.this);
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNodeKt.p(this).getRectManager().s(this.f28575b);
    }
}
