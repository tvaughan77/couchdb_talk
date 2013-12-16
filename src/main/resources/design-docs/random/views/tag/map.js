function(doc) {
    if ('name' in doc && 'albums' in doc) {
        doc.albums.forEach(function(album) {
            album.tracks.forEach(function(track) {
                track.tags.forEach(function(tag) {
                   emit(tag.random, tag.idstr); 
                });
            });
        });
    }
}