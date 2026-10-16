package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public abstract class PagingDataEvent<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Append<T> extends PagingDataEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f50336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f50337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f50338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f50339d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Append(int i3, List inserted, int i4, int i5) {
            super(null);
            Intrinsics.checkNotNullParameter(inserted, "inserted");
            this.f50336a = i3;
            this.f50337b = inserted;
            this.f50338c = i4;
            this.f50339d = i5;
        }

        public final List a() {
            return this.f50337b;
        }

        public final int b() {
            return this.f50338c;
        }

        public final int c() {
            return this.f50339d;
        }

        public final int d() {
            return this.f50336a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Append)) {
                return false;
            }
            Append append = (Append) obj;
            return this.f50336a == append.f50336a && Intrinsics.areEqual(this.f50337b, append.f50337b) && this.f50338c == append.f50338c && this.f50339d == append.f50339d;
        }

        public int hashCode() {
            return Integer.hashCode(this.f50336a) + this.f50337b.hashCode() + Integer.hashCode(this.f50338c) + Integer.hashCode(this.f50339d);
        }

        public String toString() {
            return StringsKt.p("PagingDataEvent.Append loaded " + this.f50337b.size() + " items (\n                    |   startIndex: " + this.f50336a + "\n                    |   first item: " + CollectionsKt.firstOrNull(this.f50337b) + "\n                    |   last item: " + CollectionsKt.lastOrNull(this.f50337b) + "\n                    |   newPlaceholdersBefore: " + this.f50338c + "\n                    |   oldPlaceholdersBefore: " + this.f50339d + "\n                    |)\n                    |", null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DropAppend<T> extends PagingDataEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f50340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f50341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f50342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f50343d;

        public DropAppend(int i3, int i4, int i5, int i6) {
            super(null);
            this.f50340a = i3;
            this.f50341b = i4;
            this.f50342c = i5;
            this.f50343d = i6;
        }

        public final int a() {
            return this.f50341b;
        }

        public final int b() {
            return this.f50342c;
        }

        public final int c() {
            return this.f50343d;
        }

        public final int d() {
            return this.f50340a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DropAppend)) {
                return false;
            }
            DropAppend dropAppend = (DropAppend) obj;
            return this.f50340a == dropAppend.f50340a && this.f50341b == dropAppend.f50341b && this.f50342c == dropAppend.f50342c && this.f50343d == dropAppend.f50343d;
        }

        public int hashCode() {
            return Integer.hashCode(this.f50340a) + Integer.hashCode(this.f50341b) + Integer.hashCode(this.f50342c) + Integer.hashCode(this.f50343d);
        }

        public String toString() {
            return StringsKt.p("PagingDataEvent.DropAppend dropped " + this.f50341b + " items (\n                    |   startIndex: " + this.f50340a + "\n                    |   dropCount: " + this.f50341b + "\n                    |   newPlaceholdersBefore: " + this.f50342c + "\n                    |   oldPlaceholdersBefore: " + this.f50343d + "\n                    |)\n                    |", null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DropPrepend<T> extends PagingDataEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f50344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f50345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f50346c;

        public DropPrepend(int i3, int i4, int i5) {
            super(null);
            this.f50344a = i3;
            this.f50345b = i4;
            this.f50346c = i5;
        }

        public final int a() {
            return this.f50344a;
        }

        public final int b() {
            return this.f50345b;
        }

        public final int c() {
            return this.f50346c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DropPrepend)) {
                return false;
            }
            DropPrepend dropPrepend = (DropPrepend) obj;
            return this.f50344a == dropPrepend.f50344a && this.f50345b == dropPrepend.f50345b && this.f50346c == dropPrepend.f50346c;
        }

        public int hashCode() {
            return Integer.hashCode(this.f50344a) + Integer.hashCode(this.f50345b) + Integer.hashCode(this.f50346c);
        }

        public String toString() {
            return StringsKt.p("PagingDataEvent.DropPrepend dropped " + this.f50344a + " items (\n                    |   dropCount: " + this.f50344a + "\n                    |   newPlaceholdersBefore: " + this.f50345b + "\n                    |   oldPlaceholdersBefore: " + this.f50346c + "\n                    |)\n                    |", null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Prepend<T> extends PagingDataEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f50347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f50348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f50349c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Prepend(List inserted, int i3, int i4) {
            super(null);
            Intrinsics.checkNotNullParameter(inserted, "inserted");
            this.f50347a = inserted;
            this.f50348b = i3;
            this.f50349c = i4;
        }

        public final List a() {
            return this.f50347a;
        }

        public final int b() {
            return this.f50348b;
        }

        public final int c() {
            return this.f50349c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Prepend)) {
                return false;
            }
            Prepend prepend = (Prepend) obj;
            return Intrinsics.areEqual(this.f50347a, prepend.f50347a) && this.f50348b == prepend.f50348b && this.f50349c == prepend.f50349c;
        }

        public int hashCode() {
            return this.f50347a.hashCode() + Integer.hashCode(this.f50348b) + Integer.hashCode(this.f50349c);
        }

        public String toString() {
            return StringsKt.p("PagingDataEvent.Prepend loaded " + this.f50347a.size() + " items (\n                    |   first item: " + CollectionsKt.firstOrNull(this.f50347a) + "\n                    |   last item: " + CollectionsKt.lastOrNull(this.f50347a) + "\n                    |   newPlaceholdersBefore: " + this.f50348b + "\n                    |   oldPlaceholdersBefore: " + this.f50349c + "\n                    |)\n                    |", null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Refresh<T> extends PagingDataEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PlaceholderPaddedList f50350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PlaceholderPaddedList f50351b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Refresh(PlaceholderPaddedList newList, PlaceholderPaddedList previousList) {
            super(null);
            Intrinsics.checkNotNullParameter(newList, "newList");
            Intrinsics.checkNotNullParameter(previousList, "previousList");
            this.f50350a = newList;
            this.f50351b = previousList;
        }

        public final PlaceholderPaddedList a() {
            return this.f50350a;
        }

        public final PlaceholderPaddedList b() {
            return this.f50351b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Refresh)) {
                return false;
            }
            Refresh refresh = (Refresh) obj;
            return this.f50350a.d() == refresh.f50350a.d() && this.f50350a.f() == refresh.f50350a.f() && this.f50350a.getSize() == refresh.f50350a.getSize() && this.f50350a.a() == refresh.f50350a.a() && this.f50351b.d() == refresh.f50351b.d() && this.f50351b.f() == refresh.f50351b.f() && this.f50351b.getSize() == refresh.f50351b.getSize() && this.f50351b.a() == refresh.f50351b.a();
        }

        public int hashCode() {
            return this.f50350a.hashCode() + this.f50351b.hashCode();
        }

        public String toString() {
            return StringsKt.p("PagingDataEvent.Refresh loaded newList\n                    |   newList (\n                    |       placeholdersBefore: " + this.f50350a.d() + "\n                    |       placeholdersAfter: " + this.f50350a.f() + "\n                    |       size: " + this.f50350a.getSize() + "\n                    |       dataCount: " + this.f50350a.a() + "\n                    |   )\n                    |   previousList (\n                    |       placeholdersBefore: " + this.f50351b.d() + "\n                    |       placeholdersAfter: " + this.f50351b.f() + "\n                    |       size: " + this.f50351b.getSize() + "\n                    |       dataCount: " + this.f50351b.a() + "\n                    |   )\n                    |", null, 1, null);
        }
    }

    public /* synthetic */ PagingDataEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PagingDataEvent() {
    }
}
