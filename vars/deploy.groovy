/**
 * Global variable 'deploy'
 * Created by xiaoyao9184 on 2018/11/21.
 */

//check file exist
def check_file_exists(path) {
    def file = new File(path)
    return file.exists()
}

//check path not exist or path is manage by git
def check_path_not_exists_or_manage_by_git(path) {
    def pathFile = new File(path)
    if (pathFile.exists()) {
        def gitFile = new File("${path}/.git")
        if (gitFile.exists()) {
            return true
        }
    } else {
        return true
    }
    return false
}

//get path sub files list 
def get_path_list_file_info(path) {
    def fileList = new File(path)
        .listFiles()
        .collect {
            [
                'name': it.getName(), 
                'absolutePath': it.getAbsolutePath(),
                'lastModified': it.lastModified(),
                'length': it.length(),
                'isFile': it.isFile(),
                'isDirectory': it.isDirectory(),
                'isHidden': it.isHidden()
            ]
        }
    return fileList
}

//rename file
def rename_file(oldPath,newPath) {
    def file = new File(oldPath)
    file.renameTo(newPath)
}