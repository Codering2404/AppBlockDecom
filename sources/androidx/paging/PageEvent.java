package androidx.paging;

import androidx.glance.session.ecY.lisODU;
import androidx.paging.LoadState;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
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
public abstract class PageEvent<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class Drop<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoadType f49942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f49943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f49944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f49945d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f49946a;

            static {
                int[] iArr = new int[LoadType.values().length];
                try {
                    iArr[LoadType.APPEND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LoadType.PREPEND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f49946a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drop(LoadType loadType, int i3, int i4, int i5) {
            super(null);
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            this.f49942a = loadType;
            this.f49943b = i3;
            this.f49944c = i4;
            this.f49945d = i5;
            if (loadType == LoadType.REFRESH) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
            }
            if (j() <= 0) {
                throw new IllegalArgumentException(("Drop count must be > 0, but was " + j()).toString());
            }
            if (i5 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("Invalid placeholdersRemaining " + i5).toString());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Drop)) {
                return false;
            }
            Drop drop = (Drop) obj;
            return this.f49942a == drop.f49942a && this.f49943b == drop.f49943b && this.f49944c == drop.f49944c && this.f49945d == drop.f49945d;
        }

        public final LoadType g() {
            return this.f49942a;
        }

        public final int h() {
            return this.f49944c;
        }

        public int hashCode() {
            return (((((this.f49942a.hashCode() * 31) + Integer.hashCode(this.f49943b)) * 31) + Integer.hashCode(this.f49944c)) * 31) + Integer.hashCode(this.f49945d);
        }

        public final int i() {
            return this.f49943b;
        }

        public final int j() {
            return (this.f49944c - this.f49943b) + 1;
        }

        public final int k() {
            return this.f49945d;
        }

        public String toString() {
            String str;
            int i3 = WhenMappings.f49946a[this.f49942a.ordinal()];
            if (i3 == 1) {
                str = "end";
            } else {
                if (i3 != 2) {
                    throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
                }
                str = lisODU.wOjT;
            }
            return StringsKt.p("PageEvent.Drop from the " + str + " (\n                    |   minPageOffset: " + this.f49943b + "\n                    |   maxPageOffset: " + this.f49944c + "\n                    |   placeholdersRemaining: " + this.f49945d + "\n                    |)", null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Insert<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Companion f49947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Insert f49948h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoadType f49949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f49950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f49951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f49952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final LoadStates f49953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final LoadStates f49954f;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ Insert d(Companion companion, List list, int i3, int i4, LoadStates loadStates, LoadStates loadStates2, int i5, Object obj) {
                if ((i5 & 16) != 0) {
                    loadStates2 = null;
                }
                return companion.c(list, i3, i4, loadStates, loadStates2);
            }

            public final Insert a(List pages, int i3, LoadStates sourceLoadStates, LoadStates loadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert(LoadType.APPEND, pages, -1, i3, sourceLoadStates, loadStates, null);
            }

            public final Insert b(List pages, int i3, LoadStates sourceLoadStates, LoadStates loadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert(LoadType.PREPEND, pages, i3, -1, sourceLoadStates, loadStates, null);
            }

            public final Insert c(List pages, int i3, int i4, LoadStates sourceLoadStates, LoadStates loadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert(LoadType.REFRESH, pages, i3, i4, sourceLoadStates, loadStates, null);
            }

            public final Insert e() {
                return Insert.f49948h;
            }

            private Companion() {
            }
        }

        static {
            Companion companion = new Companion(null);
            f49947g = companion;
            List listListOf = CollectionsKt.listOf(TransformablePage.f50696e.a());
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.f49893b;
            f49948h = Companion.d(companion, listListOf, 0, 0, new LoadStates(companion2.b(), companion2.a(), companion2.a()), null, 16, null);
        }

        public /* synthetic */ Insert(LoadType loadType, List list, int i3, int i4, LoadStates loadStates, LoadStates loadStates2, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType, list, i3, i4, loadStates, loadStates2);
        }

        public static /* synthetic */ Insert i(Insert insert, LoadType loadType, List list, int i3, int i4, LoadStates loadStates, LoadStates loadStates2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                loadType = insert.f49949a;
            }
            if ((i5 & 2) != 0) {
                list = insert.f49950b;
            }
            if ((i5 & 4) != 0) {
                i3 = insert.f49951c;
            }
            if ((i5 & 8) != 0) {
                i4 = insert.f49952d;
            }
            if ((i5 & 16) != 0) {
                loadStates = insert.f49953e;
            }
            if ((i5 & 32) != 0) {
                loadStates2 = insert.f49954f;
            }
            LoadStates loadStates3 = loadStates;
            LoadStates loadStates4 = loadStates2;
            return insert.h(loadType, list, i3, i4, loadStates3, loadStates4);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009e -> B:18:0x00bf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f4 -> B:27:0x0105). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object a(kotlin.jvm.functions.Function2 r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 354
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.a(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0116  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x012a A[LOOP:0: B:30:0x0120->B:32:0x012a, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00a4 -> B:18:0x00c5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ff -> B:27:0x010b). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object c(kotlin.jvm.functions.Function2 r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 367
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.c(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0091 -> B:18:0x00b4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00de -> B:24:0x00e6). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object e(kotlin.jvm.functions.Function2 r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 290
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.e(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Insert)) {
                return false;
            }
            Insert insert = (Insert) obj;
            return this.f49949a == insert.f49949a && Intrinsics.areEqual(this.f49950b, insert.f49950b) && this.f49951c == insert.f49951c && this.f49952d == insert.f49952d && Intrinsics.areEqual(this.f49953e, insert.f49953e) && Intrinsics.areEqual(this.f49954f, insert.f49954f);
        }

        public final Insert h(LoadType loadType, List pages, int i3, int i4, LoadStates sourceLoadStates, LoadStates loadStates) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(pages, "pages");
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return new Insert(loadType, pages, i3, i4, sourceLoadStates, loadStates);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.f49949a.hashCode() * 31) + this.f49950b.hashCode()) * 31) + Integer.hashCode(this.f49951c)) * 31) + Integer.hashCode(this.f49952d)) * 31) + this.f49953e.hashCode()) * 31;
            LoadStates loadStates = this.f49954f;
            return iHashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public final LoadType j() {
            return this.f49949a;
        }

        public final LoadStates k() {
            return this.f49954f;
        }

        public final List l() {
            return this.f49950b;
        }

        public final int m() {
            return this.f49952d;
        }

        public final int n() {
            return this.f49951c;
        }

        public final LoadStates o() {
            return this.f49953e;
        }

        public String toString() {
            List listB;
            List listB2;
            Iterator<T> it = this.f49950b.iterator();
            int size = 0;
            while (it.hasNext()) {
                size += ((TransformablePage) it.next()).b().size();
            }
            int i3 = this.f49951c;
            String strValueOf = IntegrityManager.INTEGRITY_TYPE_NONE;
            String strValueOf2 = i3 != -1 ? String.valueOf(i3) : IntegrityManager.INTEGRITY_TYPE_NONE;
            int i4 = this.f49952d;
            if (i4 != -1) {
                strValueOf = String.valueOf(i4);
            }
            LoadStates loadStates = this.f49954f;
            StringBuilder sb = new StringBuilder();
            sb.append("PageEvent.Insert for ");
            sb.append(this.f49949a);
            sb.append(", with ");
            sb.append(size);
            sb.append(" items (\n                    |   first item: ");
            TransformablePage transformablePage = (TransformablePage) CollectionsKt.firstOrNull(this.f49950b);
            sb.append((transformablePage == null || (listB2 = transformablePage.b()) == null) ? null : CollectionsKt.firstOrNull(listB2));
            sb.append("\n                    |   last item: ");
            TransformablePage transformablePage2 = (TransformablePage) CollectionsKt.lastOrNull(this.f49950b);
            sb.append((transformablePage2 == null || (listB = transformablePage2.b()) == null) ? null : CollectionsKt.lastOrNull(listB));
            sb.append("\n                    |   placeholdersBefore: ");
            sb.append(strValueOf2);
            sb.append("\n                    |   placeholdersAfter: ");
            sb.append(strValueOf);
            sb.append("\n                    |   sourceLoadStates: ");
            sb.append(this.f49953e);
            sb.append("\n                    ");
            String string = sb.toString();
            if (loadStates != null) {
                string = string + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.p(string + "|)", null, 1, null);
        }

        private Insert(LoadType loadType, List list, int i3, int i4, LoadStates loadStates, LoadStates loadStates2) {
            super(null);
            this.f49949a = loadType;
            this.f49950b = list;
            this.f49951c = i3;
            this.f49952d = i4;
            this.f49953e = loadStates;
            this.f49954f = loadStates2;
            if (loadType != LoadType.APPEND && i3 < 0) {
                throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + i3).toString());
            }
            if (loadType == LoadType.PREPEND || i4 >= 0) {
                if (loadType == LoadType.REFRESH && list.isEmpty()) {
                    throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.");
                }
            } else {
                throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + i4).toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LoadStateUpdate<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoadStates f50001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LoadStates f50002b;

        public /* synthetic */ LoadStateUpdate(LoadStates loadStates, LoadStates loadStates2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadStates, (i3 & 2) != 0 ? null : loadStates2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadStateUpdate)) {
                return false;
            }
            LoadStateUpdate loadStateUpdate = (LoadStateUpdate) obj;
            return Intrinsics.areEqual(this.f50001a, loadStateUpdate.f50001a) && Intrinsics.areEqual(this.f50002b, loadStateUpdate.f50002b);
        }

        public final LoadStates g() {
            return this.f50002b;
        }

        public final LoadStates h() {
            return this.f50001a;
        }

        public int hashCode() {
            int iHashCode = this.f50001a.hashCode() * 31;
            LoadStates loadStates = this.f50002b;
            return iHashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public String toString() {
            LoadStates loadStates = this.f50002b;
            String str = "PageEvent.LoadStateUpdate (\n                    |   sourceLoadStates: " + this.f50001a + "\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.p(str + "|)", null, 1, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadStateUpdate(LoadStates source, LoadStates loadStates) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.f50001a = source;
            this.f50002b = loadStates;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StaticList<T> extends PageEvent<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f50003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LoadStates f50004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LoadStates f50005c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StaticList(List data, LoadStates loadStates, LoadStates loadStates2) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.f50003a = data;
            this.f50004b = loadStates;
            this.f50005c = loadStates2;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0073 -> B:21:0x0077). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object a(kotlin.jvm.functions.Function2 r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof androidx.paging.PageEvent$StaticList$filter$1
                if (r0 == 0) goto L13
                r0 = r10
                androidx.paging.PageEvent$StaticList$filter$1 r0 = (androidx.paging.PageEvent$StaticList$filter$1) r0
                int r1 = r0.f50013i
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50013i = r1
                goto L18
            L13:
                androidx.paging.PageEvent$StaticList$filter$1 r0 = new androidx.paging.PageEvent$StaticList$filter$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.f50011g
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50013i
                r3 = 1
                if (r2 == 0) goto L43
                if (r2 != r3) goto L3b
                java.lang.Object r9 = r0.f50010f
                java.lang.Object r2 = r0.f50009d
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r0.f50008c
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r0.f50007b
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                java.lang.Object r6 = r0.f50006a
                androidx.paging.PageEvent$StaticList r6 = (androidx.paging.PageEvent.StaticList) r6
                kotlin.ResultKt.b(r10)
                goto L77
            L3b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L43:
                kotlin.ResultKt.b(r10)
                java.util.List r10 = r8.f50003a
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r10 = r10.iterator()
                r6 = r8
                r4 = r2
                r2 = r10
            L56:
                boolean r10 = r2.hasNext()
                if (r10 == 0) goto L84
                java.lang.Object r10 = r2.next()
                r0.f50006a = r6
                r0.f50007b = r9
                r0.f50008c = r4
                r0.f50009d = r2
                r0.f50010f = r10
                r0.f50013i = r3
                java.lang.Object r5 = r9.invoke(r10, r0)
                if (r5 != r1) goto L73
                return r1
            L73:
                r7 = r5
                r5 = r9
                r9 = r10
                r10 = r7
            L77:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L82
                r4.add(r9)
            L82:
                r9 = r5
                goto L56
            L84:
                java.util.List r4 = (java.util.List) r4
                androidx.paging.LoadStates r9 = r6.f50004b
                androidx.paging.LoadStates r10 = r6.f50005c
                androidx.paging.PageEvent$StaticList r0 = new androidx.paging.PageEvent$StaticList
                r0.<init>(r4, r9, r10)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.a(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:21:0x0073). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object c(kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.paging.PageEvent$StaticList$flatMap$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.paging.PageEvent$StaticList$flatMap$1 r0 = (androidx.paging.PageEvent$StaticList$flatMap$1) r0
                int r1 = r0.f50020h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50020h = r1
                goto L18
            L13:
                androidx.paging.PageEvent$StaticList$flatMap$1 r0 = new androidx.paging.PageEvent$StaticList$flatMap$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f50018f
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50020h
                r3 = 1
                if (r2 == 0) goto L41
                if (r2 != r3) goto L39
                java.lang.Object r8 = r0.f50017d
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r2 = r0.f50016c
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.Object r4 = r0.f50015b
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                java.lang.Object r5 = r0.f50014a
                androidx.paging.PageEvent$StaticList r5 = (androidx.paging.PageEvent.StaticList) r5
                kotlin.ResultKt.b(r9)
                goto L73
            L39:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L41:
                kotlin.ResultKt.b(r9)
                java.util.List r9 = r7.f50003a
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r9 = r9.iterator()
                r5 = r9
                r9 = r8
                r8 = r5
                r5 = r7
            L55:
                boolean r4 = r8.hasNext()
                if (r4 == 0) goto L7a
                java.lang.Object r4 = r8.next()
                r0.f50014a = r5
                r0.f50015b = r9
                r0.f50016c = r2
                r0.f50017d = r8
                r0.f50020h = r3
                java.lang.Object r4 = r9.invoke(r4, r0)
                if (r4 != r1) goto L70
                return r1
            L70:
                r6 = r4
                r4 = r9
                r9 = r6
            L73:
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                kotlin.collections.CollectionsKt.addAll(r2, r9)
                r9 = r4
                goto L55
            L7a:
                java.util.List r2 = (java.util.List) r2
                androidx.paging.LoadStates r8 = r5.f50004b
                androidx.paging.LoadStates r9 = r5.f50005c
                androidx.paging.PageEvent$StaticList r0 = new androidx.paging.PageEvent$StaticList
                r0.<init>(r2, r8, r9)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.c(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007d -> B:21:0x0080). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object e(kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.paging.PageEvent$StaticList$map$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.paging.PageEvent$StaticList$map$1 r0 = (androidx.paging.PageEvent$StaticList$map$1) r0
                int r1 = r0.f50028i
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50028i = r1
                goto L18
            L13:
                androidx.paging.PageEvent$StaticList$map$1 r0 = new androidx.paging.PageEvent$StaticList$map$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f50026g
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50028i
                r3 = 1
                if (r2 == 0) goto L45
                if (r2 != r3) goto L3d
                java.lang.Object r8 = r0.f50025f
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.Object r2 = r0.f50024d
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r0.f50023c
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r0.f50022b
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                java.lang.Object r6 = r0.f50021a
                androidx.paging.PageEvent$StaticList r6 = (androidx.paging.PageEvent.StaticList) r6
                kotlin.ResultKt.b(r9)
                goto L80
            L3d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L45:
                kotlin.ResultKt.b(r9)
                java.util.List r9 = r7.f50003a
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.ArrayList r2 = new java.util.ArrayList
                r4 = 10
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r4)
                r2.<init>(r4)
                java.util.Iterator r9 = r9.iterator()
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                r6 = r7
            L60:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L86
                java.lang.Object r4 = r2.next()
                r0.f50021a = r6
                r0.f50022b = r9
                r0.f50023c = r8
                r0.f50024d = r2
                r0.f50025f = r8
                r0.f50028i = r3
                java.lang.Object r4 = r9.invoke(r4, r0)
                if (r4 != r1) goto L7d
                return r1
            L7d:
                r5 = r9
                r9 = r4
                r4 = r8
            L80:
                r8.add(r9)
                r8 = r4
                r9 = r5
                goto L60
            L86:
                java.util.List r8 = (java.util.List) r8
                androidx.paging.LoadStates r9 = r6.f50004b
                androidx.paging.LoadStates r0 = r6.f50005c
                androidx.paging.PageEvent$StaticList r1 = new androidx.paging.PageEvent$StaticList
                r1.<init>(r8, r9, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.e(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StaticList)) {
                return false;
            }
            StaticList staticList = (StaticList) obj;
            return Intrinsics.areEqual(this.f50003a, staticList.f50003a) && Intrinsics.areEqual(this.f50004b, staticList.f50004b) && Intrinsics.areEqual(this.f50005c, staticList.f50005c);
        }

        public final List g() {
            return this.f50003a;
        }

        public final LoadStates h() {
            return this.f50005c;
        }

        public int hashCode() {
            int iHashCode = this.f50003a.hashCode() * 31;
            LoadStates loadStates = this.f50004b;
            int iHashCode2 = (iHashCode + (loadStates == null ? 0 : loadStates.hashCode())) * 31;
            LoadStates loadStates2 = this.f50005c;
            return iHashCode2 + (loadStates2 != null ? loadStates2.hashCode() : 0);
        }

        public final LoadStates i() {
            return this.f50004b;
        }

        public String toString() {
            LoadStates loadStates = this.f50005c;
            String str = "PageEvent.StaticList with " + this.f50003a.size() + " items (\n                    |   first item: " + CollectionsKt.firstOrNull(this.f50003a) + "\n                    |   last item: " + CollectionsKt.lastOrNull(this.f50003a) + "\n                    |   sourceLoadStates: " + this.f50004b + "\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.p(str + "|)", null, 1, null);
        }
    }

    public /* synthetic */ PageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    static /* synthetic */ Object d(PageEvent pageEvent, Function2 function2, Continuation continuation) {
        Intrinsics.checkNotNull(pageEvent, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.flatMap>");
        return pageEvent;
    }

    static /* synthetic */ Object f(PageEvent pageEvent, Function2 function2, Continuation continuation) {
        Intrinsics.checkNotNull(pageEvent, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.map>");
        return pageEvent;
    }

    public Object a(Function2 function2, Continuation continuation) {
        return b(this, function2, continuation);
    }

    public Object c(Function2 function2, Continuation continuation) {
        return d(this, function2, continuation);
    }

    public Object e(Function2 function2, Continuation continuation) {
        return f(this, function2, continuation);
    }

    private PageEvent() {
    }

    static /* synthetic */ Object b(PageEvent pageEvent, Function2 function2, Continuation continuation) {
        return pageEvent;
    }
}
