package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.UndoManager_jvmKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class TextUndoOperation {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f10981i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Saver f10982j = new Saver<TextUndoOperation, Object>() { // from class: androidx.compose.foundation.text.input.internal.undo.TextUndoOperation$Companion$Saver$1
        @Override // androidx.compose.runtime.saveable.Saver
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public TextUndoOperation b(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj2).intValue();
            Object obj3 = list.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = list.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
            Object obj5 = list.get(3);
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue2 = ((Integer) obj5).intValue();
            Object obj6 = list.get(4);
            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
            long jB = TextRangeKt.b(iIntValue2, ((Integer) obj6).intValue());
            Object obj7 = list.get(5);
            Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue3 = ((Integer) obj7).intValue();
            Object obj8 = list.get(6);
            Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Int");
            long jB2 = TextRangeKt.b(iIntValue3, ((Integer) obj8).intValue());
            Object obj9 = list.get(7);
            Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Long");
            return new TextUndoOperation(iIntValue, (String) obj3, (String) obj4, jB, jB2, ((Long) obj9).longValue(), false, 64, null);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object a(SaverScope saverScope, TextUndoOperation textUndoOperation) {
            return CollectionsKt.listOf(Integer.valueOf(textUndoOperation.d()), textUndoOperation.h(), textUndoOperation.f(), Integer.valueOf(TextRange.n(textUndoOperation.g())), Integer.valueOf(TextRange.i(textUndoOperation.g())), Integer.valueOf(TextRange.n(textUndoOperation.e())), Integer.valueOf(TextRange.i(textUndoOperation.e())), Long.valueOf(textUndoOperation.j()));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f10986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f10987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f10988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f10989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextEditType f10990h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return TextUndoOperation.f10982j;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextUndoOperation(int i3, String str, String str2, long j3, long j4, long j5, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, j3, j4, j5, z2);
    }

    public final boolean b() {
        return this.f10989g;
    }

    public final TextDeleteType c() {
        return this.f10990h != TextEditType.f10972b ? TextDeleteType.f10968d : !TextRange.h(this.f10987e) ? TextDeleteType.f10968d : TextRange.h(this.f10986d) ? TextRange.n(this.f10986d) > TextRange.n(this.f10987e) ? TextDeleteType.f10965a : TextDeleteType.f10966b : (TextRange.n(this.f10986d) == TextRange.n(this.f10987e) && TextRange.n(this.f10986d) == this.f10983a) ? TextDeleteType.f10967c : TextDeleteType.f10968d;
    }

    public final int d() {
        return this.f10983a;
    }

    public final long e() {
        return this.f10987e;
    }

    public final String f() {
        return this.f10985c;
    }

    public final long g() {
        return this.f10986d;
    }

    public final String h() {
        return this.f10984b;
    }

    public final TextEditType i() {
        return this.f10990h;
    }

    public final long j() {
        return this.f10988f;
    }

    private TextUndoOperation(int i3, String str, String str2, long j3, long j4, long j5, boolean z2) {
        this.f10983a = i3;
        this.f10984b = str;
        this.f10985c = str2;
        this.f10986d = j3;
        this.f10987e = j4;
        this.f10988f = j5;
        this.f10989g = z2;
        if (str.length() == 0 && str2.length() == 0) {
            throw new IllegalArgumentException("Either pre or post text must not be empty");
        }
        this.f10990h = (str.length() != 0 || str2.length() <= 0) ? (str.length() <= 0 || str2.length() != 0) ? TextEditType.f10973c : TextEditType.f10972b : TextEditType.f10971a;
    }

    public /* synthetic */ TextUndoOperation(int i3, String str, String str2, long j3, long j4, long j5, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, j3, j4, (i4 & 32) != 0 ? UndoManager_jvmKt.a() : j5, (i4 & 64) != 0 ? true : z2, null);
    }
}
