version = "0.0.1"
description = "Map Local extension. It enables to use the content of local files as a response from requests."

zapAddOn {
    addOnName.set("Map Local")
    zapVersion.set("2.12.0")

    manifest {
        author.set("Andrey Maksimov")
    }
}

crowdin {
    configuration {
        val resourcesPath = "org/zaproxy/addon/${zapAddOn.addOnId.get()}/resources/"
        tokens.put("%messagesPath%", resourcesPath)
        tokens.put("%helpPath%", resourcesPath)
    }
}
