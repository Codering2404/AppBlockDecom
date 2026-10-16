package okio.internal;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;

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
public final class ResourceFileSystem extends FileSystem {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Companion f145171f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Path f145172g = Path.Companion.e(Path.f145073b, "/", false, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f145173e;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(Path path) {
            return !StringsKt.D(path.e(), ".class", true);
        }

        public final Path b() {
            return ResourceFileSystem.f145172g;
        }

        public final Path d(Path path, Path base) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            Intrinsics.checkNotNullParameter(base, "base");
            return b().j(StringsKt.N(StringsKt.K0(path.toString(), base.toString()), '\\', '/', false, 4, null));
        }

        public final Pair f(URL url) {
            Intrinsics.checkNotNullParameter(url, "<this>");
            if (Intrinsics.areEqual(url.getProtocol(), "file")) {
                return TuplesKt.a(FileSystem.f145034b, Path.Companion.d(Path.f145073b, new File(url.toURI()), false, 1, null));
            }
            return null;
        }

        public final Pair g(URL url) {
            int iU0;
            Intrinsics.checkNotNullParameter(url, "<this>");
            String string = url.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString()");
            if (!StringsKt.U(string, "jar:file:", false, 2, null) || (iU0 = StringsKt.u0(string, "!", 0, false, 6, null)) == -1) {
                return null;
            }
            Path.Companion companion = Path.f145073b;
            String strSubstring = string.substring(4, iU0);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return TuplesKt.a(ZipFilesKt.d(Path.Companion.d(companion, new File(URI.create(strSubstring)), false, 1, null), FileSystem.f145034b, new Function1<ZipEntry, Boolean>() { // from class: okio.internal.ResourceFileSystem$Companion$toJarRoot$zip$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(ZipEntry entry) {
                    Intrinsics.checkNotNullParameter(entry, "entry");
                    return Boolean.valueOf(ResourceFileSystem.f145171f.c(entry.a()));
                }
            }), b());
        }

        private Companion() {
        }

        public final List e(ClassLoader classLoader) throws IOException {
            Intrinsics.checkNotNullParameter(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(\"\")");
            ArrayList list = Collections.list(resources);
            Intrinsics.checkNotNullExpressionValue(list, "list(this)");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj = list.get(i4);
                i4++;
                URL it = (URL) obj;
                Companion companion = ResourceFileSystem.f145171f;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Pair pairF = companion.f(it);
                if (pairF != null) {
                    arrayList.add(pairF);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources(YznnJpHcAmeoW.IEblM);
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList list2 = Collections.list(resources2);
            Intrinsics.checkNotNullExpressionValue(list2, "list(this)");
            ArrayList arrayList2 = new ArrayList();
            int size2 = list2.size();
            while (i3 < size2) {
                Object obj2 = list2.get(i3);
                i3++;
                URL it2 = (URL) obj2;
                Companion companion2 = ResourceFileSystem.f145171f;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Pair pairG = companion2.g(it2);
                if (pairG != null) {
                    arrayList2.add(pairG);
                }
            }
            return CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        }
    }

    public ResourceFileSystem(final ClassLoader classLoader, boolean z2) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.f145173e = LazyKt.b(new Function0<List<? extends Pair<? extends FileSystem, ? extends Path>>>() { // from class: okio.internal.ResourceFileSystem$roots$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List invoke() {
                return ResourceFileSystem.f145171f.e(classLoader);
            }
        });
        if (z2) {
            x().size();
        }
    }

    private final Path w(Path path) {
        return f145172g.l(path, true);
    }

    private final List x() {
        return (List) this.f145173e.getValue();
    }

    private final String y(Path path) {
        return w(path).i(f145172g).toString();
    }

    @Override // okio.FileSystem
    public Sink b(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void c(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void g(Path dir, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void i(Path path, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public List k(Path dir) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String strY = y(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z2 = false;
        for (Pair pair : x()) {
            FileSystem fileSystem = (FileSystem) pair.a();
            Path path = (Path) pair.b();
            try {
                List listK = fileSystem.k(path.j(strY));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listK) {
                    if (f145171f.c((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    arrayList2.add(f145171f.d((Path) obj2, path));
                }
                CollectionsKt.addAll(linkedHashSet, arrayList2);
                z2 = true;
            } catch (IOException unused) {
            }
        }
        if (z2) {
            return CollectionsKt.toList(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // okio.FileSystem
    public List l(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String strY = y(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = x().iterator();
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            FileSystem fileSystem = (FileSystem) pair.a();
            Path path = (Path) pair.b();
            List listL = fileSystem.l(path.j(strY));
            if (listL != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listL) {
                    if (f145171f.c((Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    arrayList3.add(f145171f.d((Path) obj2, path));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                CollectionsKt.addAll(linkedHashSet, arrayList);
                z2 = true;
            }
        }
        if (z2) {
            return CollectionsKt.toList(linkedHashSet);
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileMetadata n(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!f145171f.c(path)) {
            return null;
        }
        String strY = y(path);
        for (Pair pair : x()) {
            FileMetadata fileMetadataN = ((FileSystem) pair.a()).n(((Path) pair.b()).j(strY));
            if (fileMetadataN != null) {
                return fileMetadataN;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle o(Path file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!f145171f.c(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String strY = y(file);
        for (Pair pair : x()) {
            try {
                return ((FileSystem) pair.a()).o(((Path) pair.b()).j(strY));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // okio.FileSystem
    public FileHandle q(Path file, boolean z2, boolean z3) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    public Sink s(Path file, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Source t(Path file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!f145171f.c(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String strY = y(file);
        for (Pair pair : x()) {
            try {
                return ((FileSystem) pair.a()).t(((Path) pair.b()).j(strY));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + file);
    }
}
