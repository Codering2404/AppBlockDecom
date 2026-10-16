package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DiskCacheStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DiskCacheStrategy f66405a = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.1
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DiskCacheStrategy f66406b = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.2
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DiskCacheStrategy f66407c = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.3
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DiskCacheStrategy f66408d = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.4
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DiskCacheStrategy f66409e = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.5
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z2 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy);
}
