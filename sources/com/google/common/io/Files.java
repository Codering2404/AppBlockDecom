package com.google.common.io;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.graph.SuccessorsFunction;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Files {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SuccessorsFunction f85268a = new SuccessorsFunction<File>() { // from class: com.google.common.io.Files.2
        @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Iterable a(File file) {
            File[] fileArrListFiles;
            return (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) ? ImmutableList.y() : Collections.unmodifiableList(Arrays.asList(fileArrListFiles));
        }
    };

    /* JADX INFO: renamed from: com.google.common.io.Files$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements LineProcessor<List<String>> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FileByteSink extends ByteSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f85269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImmutableSet f85270b;

        public String toString() {
            return "Files.asByteSink(" + this.f85269a + ", " + this.f85270b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FileByteSource extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f85271a;

        @Override // com.google.common.io.ByteSource
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileInputStream a() {
            return new FileInputStream(this.f85271a);
        }

        public String toString() {
            return "Files.asByteSource(" + this.f85271a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum FilePredicate implements Predicate<File> {
        IS_DIRECTORY { // from class: com.google.common.io.Files.FilePredicate.1
            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean apply(File file) {
                return file.isDirectory();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isDirectory()";
            }
        },
        IS_FILE { // from class: com.google.common.io.Files.FilePredicate.2
            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean apply(File file) {
                return file.isFile();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Files.isFile()";
            }
        };

        /* synthetic */ FilePredicate(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
