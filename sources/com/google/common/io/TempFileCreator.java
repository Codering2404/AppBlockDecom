package com.google.common.io;

import com.facebook.GraphRequest;
import com.google.common.base.StandardSystemProperty;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.io.TempFileCreator;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class TempFileCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final TempFileCreator f85290a = b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JavaIoCreator extends TempFileCreator {
        private JavaIoCreator() {
            super();
        }

        @Override // com.google.common.io.TempFileCreator
        File a(String str) {
            return File.createTempFile(str, null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ThrowingCreator extends TempFileCreator {
        private ThrowingCreator() {
            super();
        }

        @Override // com.google.common.io.TempFileCreator
        File a(String str) throws IOException {
            throw new IOException("Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().");
        }
    }

    private static TempFileCreator b() {
        try {
            try {
                return new JavaNioCreator();
            } catch (ClassNotFoundException unused) {
                return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get(null)).intValue() ? new ThrowingCreator() : new JavaIoCreator();
            }
        } catch (ClassNotFoundException unused2) {
            return new ThrowingCreator();
        } catch (IllegalAccessException unused3) {
            return new ThrowingCreator();
        } catch (NoSuchFieldException unused4) {
            return new ThrowingCreator();
        }
    }

    abstract File a(String str);

    private TempFileCreator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JavaNioCreator extends TempFileCreator {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final PermissionSupplier f85291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final PermissionSupplier f85292c;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        interface PermissionSupplier {
            FileAttribute get();
        }

        static {
            Set<String> setSupportedFileAttributeViews = FileSystems.getDefault().supportedFileAttributeViews();
            if (setSupportedFileAttributeViews.contains("posix")) {
                f85291b = new PermissionSupplier() { // from class: com.google.common.io.b
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"));
                    }
                };
                f85292c = new PermissionSupplier() { // from class: com.google.common.io.c
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
                    }
                };
            } else if (setSupportedFileAttributeViews.contains("acl")) {
                PermissionSupplier permissionSupplierI = i();
                f85292c = permissionSupplierI;
                f85291b = permissionSupplierI;
            } else {
                PermissionSupplier permissionSupplier = new PermissionSupplier() { // from class: com.google.common.io.d
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        return TempFileCreator.JavaNioCreator.f();
                    }
                };
                f85292c = permissionSupplier;
                f85291b = permissionSupplier;
            }
        }

        private JavaNioCreator() {
            super();
        }

        public static /* synthetic */ FileAttribute f() throws IOException {
            throw new IOException("unrecognized FileSystem type " + FileSystems.getDefault());
        }

        public static /* synthetic */ FileAttribute g(IOException iOException) throws IOException {
            throw new IOException("Could not find user", iOException);
        }

        private static String h() {
            String strC = StandardSystemProperty.USER_NAME.c();
            Objects.requireNonNull(strC);
            try {
                Class<?> cls = Class.forName("java.lang.ProcessHandle");
                Class<?> cls2 = Class.forName("java.lang.ProcessHandle$Info");
                Class<?> cls3 = Class.forName("java.util.Optional");
                Method method = cls.getMethod("current", null);
                Method method2 = cls.getMethod(GraphRequest.DEBUG_SEVERITY_INFO, null);
                Object objInvoke = cls3.getMethod("orElse", Object.class).invoke(cls2.getMethod("user", null).invoke(method2.invoke(method.invoke(null, null), null), null), strC);
                Objects.requireNonNull(objInvoke);
                return (String) objInvoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException unused) {
                return strC;
            } catch (InvocationTargetException e3) {
                Throwables.m(e3.getCause());
                return strC;
            }
        }

        private static PermissionSupplier i() {
            try {
                final ImmutableList immutableListZ = ImmutableList.z(AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(h())).setPermissions(EnumSet.allOf(AclEntryPermission.class)).setFlags(AclEntryFlag.DIRECTORY_INHERIT, AclEntryFlag.FILE_INHERIT).build());
                final FileAttribute<ImmutableList<AclEntry>> fileAttribute = new FileAttribute<ImmutableList<AclEntry>>() { // from class: com.google.common.io.TempFileCreator.JavaNioCreator.1
                    @Override // java.nio.file.attribute.FileAttribute
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public ImmutableList value() {
                        return immutableListZ;
                    }

                    @Override // java.nio.file.attribute.FileAttribute
                    public String name() {
                        return "acl:acl";
                    }
                };
                return new PermissionSupplier() { // from class: com.google.common.io.e
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        return TempFileCreator.JavaNioCreator.e(fileAttribute);
                    }
                };
            } catch (IOException e3) {
                return new PermissionSupplier() { // from class: com.google.common.io.f
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        return TempFileCreator.JavaNioCreator.g(e3);
                    }
                };
            }
        }

        @Override // com.google.common.io.TempFileCreator
        File a(String str) {
            return java.nio.file.Files.createTempFile(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.c(), new String[0]), str, null, f85291b.get()).toFile();
        }

        public static /* synthetic */ FileAttribute e(FileAttribute fileAttribute) {
            return fileAttribute;
        }
    }
}
