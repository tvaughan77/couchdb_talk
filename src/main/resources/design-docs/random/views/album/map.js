function(doc) {
    if ('name' in doc && 'albums' in doc) {
        doc.albums.forEach(function(album) {
            emit(album.name, album.name);
        });
    }
}