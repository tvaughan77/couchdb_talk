function(doc) {
    if ('name' in doc && 'albums' in doc) {
        doc.albums.forEach(function(album) {
            album.tracks.forEach(function(track) {
                emit(track.random, track.name);
            });
        });
    }
}