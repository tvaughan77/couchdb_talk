function(doc) {
    if ('name' in doc && 'albums' in doc) {
        doc.albums.forEach(function(album) {
            var
                    key = album.title || album.name,
                    value = {by: doc.name, album: album};
            emit(key, value);
        });
    }
}