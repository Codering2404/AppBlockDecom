package kotlin.io;

import com.google.android.gms.common.api.Api;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class FileTreeWalk implements Sequence<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f139947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileWalkDirection f139948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f139949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f139950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function2 f139951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f139952f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static abstract class DirectoryState extends WalkState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryState(File rootDir) {
            super(rootDir);
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class FileTreeWalkIterator extends AbstractIterator<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayDeque f139953a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private final class BottomUpDirectoryState extends DirectoryState {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f139955b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private File[] f139956c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f139957d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f139958e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f139959f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.f139959f = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File b() {
                if (!this.f139958e && this.f139956c == null) {
                    Function1 function1 = FileTreeWalk.this.f139949c;
                    if (function1 != null && !((Boolean) function1.invoke(a())).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = a().listFiles();
                    this.f139956c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        Function2 function2 = FileTreeWalk.this.f139951e;
                        if (function2 != null) {
                            function2.invoke(a(), new AccessDeniedException(a(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.f139958e = true;
                    }
                }
                File[] fileArr = this.f139956c;
                if (fileArr != null) {
                    int i3 = this.f139957d;
                    Intrinsics.checkNotNull(fileArr);
                    if (i3 < fileArr.length) {
                        File[] fileArr2 = this.f139956c;
                        Intrinsics.checkNotNull(fileArr2);
                        int i4 = this.f139957d;
                        this.f139957d = i4 + 1;
                        return fileArr2[i4];
                    }
                }
                if (!this.f139955b) {
                    this.f139955b = true;
                    return a();
                }
                Function1 function12 = FileTreeWalk.this.f139950d;
                if (function12 != null) {
                    function12.invoke(a());
                }
                return null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private final class SingleFileState extends WalkState {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f139960b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f139961c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingleFileState(FileTreeWalkIterator fileTreeWalkIterator, File rootFile) {
                super(rootFile);
                Intrinsics.checkNotNullParameter(rootFile, "rootFile");
                this.f139961c = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File b() {
                if (this.f139960b) {
                    return null;
                }
                this.f139960b = true;
                return a();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private final class TopDownDirectoryState extends DirectoryState {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f139962b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private File[] f139963c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f139964d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f139965e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File rootDir) {
                super(rootDir);
                Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.f139965e = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // kotlin.io.FileTreeWalk.WalkState
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.io.File b() {
                /*
                    r9 = this;
                    boolean r0 = r9.f139962b
                    r1 = 0
                    if (r0 != 0) goto L28
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.f139965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.e(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r9.a()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r9.f139962b = r0
                    java.io.File r0 = r9.a()
                    return r0
                L28:
                    java.io.File[] r0 = r9.f139963c
                    if (r0 == 0) goto L47
                    int r2 = r9.f139964d
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L47
                L35:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.f139965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.g(r0)
                    if (r0 == 0) goto L46
                    java.io.File r2 = r9.a()
                    r0.invoke(r2)
                L46:
                    return r1
                L47:
                    java.io.File[] r0 = r9.f139963c
                    if (r0 != 0) goto L92
                    java.io.File r0 = r9.a()
                    java.io.File[] r0 = r0.listFiles()
                    r9.f139963c = r0
                    if (r0 != 0) goto L76
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.f139965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.FileTreeWalk.f(r0)
                    if (r0 == 0) goto L76
                    java.io.File r2 = r9.a()
                    kotlin.io.AccessDeniedException r3 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r9.a()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r3)
                L76:
                    java.io.File[] r0 = r9.f139963c
                    if (r0 == 0) goto L80
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L92
                L80:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.f139965e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.g(r0)
                    if (r0 == 0) goto L91
                    java.io.File r2 = r9.a()
                    r0.invoke(r2)
                L91:
                    return r1
                L92:
                    java.io.File[] r0 = r9.f139963c
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r1 = r9.f139964d
                    int r2 = r1 + 1
                    r9.f139964d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState.b():java.io.File");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f139966a;

            static {
                int[] iArr = new int[FileWalkDirection.values().length];
                try {
                    iArr[FileWalkDirection.f139968a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FileWalkDirection.f139969b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f139966a = iArr;
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f139953a = arrayDeque;
            if (FileTreeWalk.this.f139947a.isDirectory()) {
                arrayDeque.push(a(FileTreeWalk.this.f139947a));
            } else if (FileTreeWalk.this.f139947a.isFile()) {
                arrayDeque.push(new SingleFileState(this, FileTreeWalk.this.f139947a));
            } else {
                done();
            }
        }

        private final DirectoryState a(File file) {
            int i3 = WhenMappings.f139966a[FileTreeWalk.this.f139948b.ordinal()];
            if (i3 == 1) {
                return new TopDownDirectoryState(this, file);
            }
            if (i3 == 2) {
                return new BottomUpDirectoryState(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File b() {
            File fileB;
            while (true) {
                WalkState walkState = (WalkState) this.f139953a.peek();
                if (walkState == null) {
                    return null;
                }
                fileB = walkState.b();
                if (fileB == null) {
                    this.f139953a.pop();
                } else {
                    if (Intrinsics.areEqual(fileB, walkState.a()) || !fileB.isDirectory() || this.f139953a.size() >= FileTreeWalk.this.f139952f) {
                        break;
                    }
                    this.f139953a.push(a(fileB));
                }
            }
            return fileB;
        }

        @Override // kotlin.collections.AbstractIterator
        protected void computeNext() {
            File fileB = b();
            if (fileB != null) {
                setNext(fileB);
            } else {
                done();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static abstract class WalkState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f139967a;

        public WalkState(File root) {
            Intrinsics.checkNotNullParameter(root, "root");
            this.f139967a = root;
        }

        public final File a() {
            return this.f139967a;
        }

        public abstract File b();
    }

    private FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i3) {
        this.f139947a = file;
        this.f139948b = fileWalkDirection;
        this.f139949c = function1;
        this.f139950d = function12;
        this.f139951e = function2;
        this.f139952f = i3;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new FileTreeWalkIterator();
    }

    /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i4 & 2) != 0 ? FileWalkDirection.f139968a : fileWalkDirection, function1, function12, function2, (i4 & 32) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(File start, FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(direction, "direction");
    }
}
