package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class TextFieldScrollerPosition {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f10008g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Saver f10009h = ListSaverKt.a(new Function2<SaverScope, TextFieldScrollerPosition, List<? extends Object>>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(SaverScope saverScope, TextFieldScrollerPosition textFieldScrollerPosition) {
            return CollectionsKt.listOf(Float.valueOf(textFieldScrollerPosition.d()), Boolean.valueOf(textFieldScrollerPosition.f() == Orientation.f6031a));
        }
    }, new Function1<List<? extends Object>, TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.TextFieldScrollerPosition$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextFieldScrollerPosition invoke(List list) {
            Object obj = list.get(1);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            Orientation orientation = ((Boolean) obj).booleanValue() ? Orientation.f6031a : Orientation.f6032b;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new TextFieldScrollerPosition(orientation, ((Float) obj2).floatValue());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableFloatState f10010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f10011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableIntState f10012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Rect f10013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f10015f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return TextFieldScrollerPosition.f10009h;
        }

        private Companion() {
        }
    }

    public TextFieldScrollerPosition(Orientation orientation, float f3) {
        this.f10010a = PrimitiveSnapshotStateKt.a(f3);
        this.f10011b = PrimitiveSnapshotStateKt.a(0.0f);
        this.f10012c = SnapshotIntStateKt.a(0);
        this.f10013d = Rect.f25601e.a();
        this.f10014e = TextRange.f28921b.a();
        this.f10015f = SnapshotStateKt.i(orientation, SnapshotStateKt.r());
    }

    private final void g(float f3) {
        this.f10011b.s(f3);
    }

    private final void j(int i3) {
        this.f10012c.a(i3);
    }

    public final void b(float f3, float f4, int i3) {
        float fD = d();
        float f5 = i3;
        float f6 = fD + f5;
        h(d() + ((f4 <= f6 && (f3 >= fD || f4 - f3 <= f5)) ? (f3 >= fD || f4 - f3 > f5) ? 0.0f : f3 - fD : f4 - f6));
    }

    public final float c() {
        return this.f10011b.c();
    }

    public final float d() {
        return this.f10010a.c();
    }

    public final int e(long j3) {
        return TextRange.n(j3) != TextRange.n(this.f10014e) ? TextRange.n(j3) : TextRange.i(j3) != TextRange.i(this.f10014e) ? TextRange.i(j3) : TextRange.l(j3);
    }

    public final Orientation f() {
        return (Orientation) this.f10015f.getValue();
    }

    public final void h(float f3) {
        this.f10010a.s(f3);
    }

    public final void i(long j3) {
        this.f10014e = j3;
    }

    public final void k(Orientation orientation, Rect rect, int i3, int i4) {
        float f3 = i4 - i3;
        g(f3);
        if (rect.o() != this.f10013d.o() || rect.r() != this.f10013d.r()) {
            boolean z2 = orientation == Orientation.f6031a;
            b(z2 ? rect.r() : rect.o(), z2 ? rect.i() : rect.p(), i3);
            this.f10013d = rect;
        }
        h(RangesKt.o(d(), 0.0f, f3));
        j(i3);
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation orientation, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, (i3 & 2) != 0 ? 0.0f : f3);
    }
}
