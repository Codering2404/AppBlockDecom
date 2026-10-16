package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
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
public final class UndoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Entry f10072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Entry f10073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Long f10075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10076f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Entry f10077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextFieldValue f10078b;

        public Entry(Entry entry, TextFieldValue textFieldValue) {
            this.f10077a = entry;
            this.f10078b = textFieldValue;
        }

        public final Entry a() {
            return this.f10077a;
        }

        public final TextFieldValue b() {
            return this.f10078b;
        }

        public final void c(Entry entry) {
            this.f10077a = entry;
        }

        public final void d(TextFieldValue textFieldValue) {
            this.f10078b = textFieldValue;
        }
    }

    public UndoManager(int i3) {
        this.f10071a = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void d() {
        /*
            r3 = this;
            androidx.compose.foundation.text.UndoManager$Entry r0 = r3.f10072b
            r1 = 0
            if (r0 == 0) goto La
            androidx.compose.foundation.text.UndoManager$Entry r2 = r0.a()
            goto Lb
        La:
            r2 = r1
        Lb:
            if (r2 != 0) goto Le
            goto L25
        Le:
            if (r0 == 0) goto L1b
            androidx.compose.foundation.text.UndoManager$Entry r2 = r0.a()
            if (r2 == 0) goto L1b
            androidx.compose.foundation.text.UndoManager$Entry r2 = r2.a()
            goto L1c
        L1b:
            r2 = r1
        L1c:
            if (r2 == 0) goto L23
            androidx.compose.foundation.text.UndoManager$Entry r0 = r0.a()
            goto Le
        L23:
            if (r0 != 0) goto L26
        L25:
            return
        L26:
            r0.c(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.UndoManager.d():void");
    }

    public static /* synthetic */ void f(UndoManager undoManager, TextFieldValue textFieldValue, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = UndoManager_jvmKt.a();
        }
        undoManager.e(textFieldValue, j3);
    }

    public final void a() {
        this.f10076f = true;
    }

    public final void b(TextFieldValue textFieldValue) {
        TextFieldValue textFieldValueB;
        this.f10076f = false;
        Entry entry = this.f10072b;
        if (Intrinsics.areEqual(textFieldValue, entry != null ? entry.b() : null)) {
            return;
        }
        String strI = textFieldValue.i();
        Entry entry2 = this.f10072b;
        if (Intrinsics.areEqual(strI, (entry2 == null || (textFieldValueB = entry2.b()) == null) ? null : textFieldValueB.i())) {
            Entry entry3 = this.f10072b;
            if (entry3 == null) {
                return;
            }
            entry3.d(textFieldValue);
            return;
        }
        this.f10072b = new Entry(this.f10072b, textFieldValue);
        this.f10073c = null;
        int length = this.f10074d + textFieldValue.i().length();
        this.f10074d = length;
        if (length > this.f10071a) {
            d();
        }
    }

    public final TextFieldValue c() {
        Entry entry = this.f10073c;
        if (entry == null) {
            return null;
        }
        this.f10073c = entry.a();
        this.f10072b = new Entry(this.f10072b, entry.b());
        this.f10074d += entry.b().i().length();
        return entry.b();
    }

    public final void e(TextFieldValue textFieldValue, long j3) {
        if (!this.f10076f) {
            Long l3 = this.f10075e;
            if (j3 <= (l3 != null ? l3.longValue() : 0L) + ((long) UndoManagerKt.a())) {
                return;
            }
        }
        this.f10075e = Long.valueOf(j3);
        b(textFieldValue);
    }

    public final TextFieldValue g() {
        Entry entryA;
        Entry entry = this.f10072b;
        if (entry == null || (entryA = entry.a()) == null) {
            return null;
        }
        this.f10072b = entryA;
        this.f10074d -= entry.b().i().length();
        this.f10073c = new Entry(this.f10073c, entry.b());
        return entryA.b();
    }

    public /* synthetic */ UndoManager(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 100000 : i3);
    }
}
