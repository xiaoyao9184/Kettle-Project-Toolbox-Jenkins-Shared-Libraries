# Kettle-Project-Toolbox-Jenkins-Shared-Libraries

Jenkins Shared Libraries for Kettle-Project-Toolbox project


# What

[**K**ettle-**P**roject-**T**oolbox](https://github.com/xiaoyao9184/Kettle-Project-Toolbox) can create deploy archive, 
so deploy can automate with jenkins.

But [In-process Script Approval](https://jenkins.io/doc/book/managing/script-approval/) will block unapproved scripts, such as File APIs.
So use **Shared Libraries** to make scripts trusted.

# Use

You can follow document [shared-libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/#global-shared-libraries)
to add shared library in `Configure System`.

The name must be `KPT_Shared_Libraries` if you use jenkinsfile in **/jenkinsfile/** directory.

Setting table for example:

| option | value |
|:----- |:----- |
| Name | KPT_Shared_Libraries |
| Default version | master |
| Load implicitly | [x] |
| Allow default version to be overridden | [x] |
| Include @Library changes in job recent changes | [x] |
| Retrieval method |
| Modern SCM | [x] |
| Source Code Management |
| GitHub | [x] |
| Project Repository | 
| Credentials | NONE |
| Owner | xiaoyao9184 |
| Repository | Kettle-Project-Toolbox-Jenkins-Shared-Libraries |


# Use with [Kettle-Project-Toolbox](https://github.com/xiaoyao9184/Kettle-Project-Toolbox)

**NOTE** only windows for now, because [Kettle-Project-Toolbox](https://github.com/xiaoyao9184/Kettle-Project-Toolbox) only for windows now!


## Config the jenkins job

Create Jenkins job use workflow(pipeline) called **KPT_SL_Deploy**,
use `Pipeline script from SCM` with this repository url,
set `Script Path` to `jenkinsfile/deploy_kpt_project.jenkinsfile`.

> Then run it will auto download [**P**entaho **D**ata **I**ntegration](https://community.hitachivantara.com/docs/DOC-1009855-data-integration-kettle) and [**K**ettle-**P**roject-**T**oolbox](https://github.com/xiaoyao9184/Kettle-Project-Toolbox) if default location not exists.

> If your internet speed is not good, 
prepare PDI and KPT in advance and put them in the default location, 
it will skip download form internet,
and KPT will not get subsequent updates.

*The default defined in the `jenkinsfile/deploy_kpt_project.jenkinsfile` pipeline script*


## Deploy in automatic

KPT deploy archive is zip file, so deploy script get archive through the file system.

Create Jenkins job for monitor new archive change in archive path on file system,
then trigger the **KPT_SL_Deploy** job.

> You can use [Syncthing](https://syncthing.net/) for remote archive synchronization,

> use [FSTrigger plugin](https://wiki.jenkins.io/display/JENKINS/FSTrigger+Plugin) for monitor **Archive Path**,
 
> and use [Parameterized Trigger plugin](https://wiki.jenkins.io/display/JENKINS/Parameterized+Trigger+Plugin) for trigger the **KPT_SL_Deploy** job.


*The* ***Archive Path*** *format is the `{ArchivePath}/{ProjectName}/{ArchiveFile}`,* ***Archive File*** *defined by KPT*

# License

GPL v3