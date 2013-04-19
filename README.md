MyFirstJEEApp
=============


## �ŏ��̈��
- _Java EE Module�����_
  - _web.xml�������ō���邯�ǁC�Ȃ�ł� 2.5 �Ȃ̂ŁC3.0 �ɒ����Ă���_
  - Java Module�ō���facet��I�ׂ�̂ŁC������ Web Application 3.0 �Ƃ��w��ł���
  - JPA��JSF�CCDI���ǉ��ł��邯�ǁC�_�E�����[�h���郉�C�u�������C�}�C�`�Ȋ����B
  - facet�ǉ�����Ƃ��� "Set up library later"�i���ƂŐݒ肷��j��I�ׂ΂����񂾂��ǁC�Ȃ�ł�CDI�ɂ͂��̍��ڂ��Ȃ�
  - ��������CDI��facet��ǉ�����K�v������̂��H���Ęb������i�P�Ƀ��C�u�����̒ǉ��ł����Ȃ�����j
- Project Structure��Module->Add��EJB�Ƃ�JPA�Ȃǂ�facet��ǉ������JavaEE5��javaee.jar������Ă���̂ŁC�܂��������_��
  - Module->Dependencies->Add��Library��from maven���� "javax:javaee-api:6.0" ��ǉ����悤���C�Ȃ�ł��_�E�����[�h�Ɏ��s����B:-(
  - �������Ȃ��̂ŁC[���̂ւ�](http://mvnrepository.com/artifact/javax/javaee-api/6.0) ���� javaee-api-6.0.jar ���Q�b�g
  - ./lib ������ɔz�u���ă��C�u�����ɒǉ��iscope��provided�j
  - **Module->Dependencies->Add��Library��from maven���� "javax:javaee-web-api:6.0" ��ǉ�����Ƃ��܂��s��**
    �iWeb Profile���ۂ����ǁCJSF/EJB3/JPA/CDI���g�����ɂ͂���ŏ\���j
- �������������� artifact �� war�t�@�C������āCglassfish�w�肵�đa�ʊm�F���Ƃ�

## �͂��߂Ă�Servlet3.0
- Web�c�[���E�B���h�E����Servlet�����ƁCServlet2.5�R���̃T�[�u���b�g�ɂȂ�̂ŁC���ʂɃN���X�����

## �͂��߂Ă�JPA2.0
- Project Structure��Module->Add��JPA��ǉ�
  - JPA Provider�� EclipseLink�Cpersistence.xml �� ./src/META-INF �ɍ��i�����Ă����� ./META-INF �ɍ��j
- persistence.xml�͋���ۂȂ̂ŁC�Œ���K�v�ȕ�����ǉ�
  - �ǉ����� persistence.xml �� artifact �ł� war �t�@�C���Ɋ܂߂�悤�ɐݒ肵�Ă����i�Y�ꂪ���j
- JPA���g���ɂ́Cglassfish���Ƀf�[�^�\�[�X���`���Ȃ��ƃ_���Ȃ̂����C�Ǘ��c�[�����g������CDB��p�ӂ�����ƃ����h�E������
  - ...�̂ŁCDB�͕ʂɗp�ӂ����Cglassfish���� Embedded Derby ������Ă��܂�
  - glassfish-resources.xml�ɐڑ��v�[����f�[�^�\�[�X���`���āCasadmin�o�R��glassfish�ɓo�^���邱�Ƃ��ł���
  - glassfish�ɖ��ߍ��� Embedded Derby �̎��̂́C$GLASSFISH_HOME/glassfish/domains/domain1/config �ɂł�������
- JPA Entity��JPA�c�[���E�B���h�E������Ƃ�₱�������ƂɂȂ�̂ŁC���ʂɃN���X�Ƃ��č��
- **���������΁CJPA Entity�̒P�̃e�X�g���Ăǂ�����Ă��񂾂낤�H**

## �͂��߂Ă�EJB3.1
- EJB facet�͗v��Ȃ��iEJB3.0�����炩�ȁH�j
- ���ʂ̃N���X����銴�o�ŁC�K���ȏꏊ��EJB3�̃Z�b�V�����r�[�������istateless�ł����ł���j
- ����͂����ƁC@PersistenceContext �� unitName ���ĕ⊮�����Ȃ��̂�ˁB:-(

## �͂��߂Ă�JSF2.2
- Project Structure��Module->Web->Add��JSF��ǉ��ifacelet��Enabled�ɂ��Ƃ��j
  - �uJSF�̃��C�u����������v�ƌ����邪 javaee-api-6.0.jar ��ݒ�ς݂Ȃ̂Ŗ������Č����i�G���[�ɂȂ�Ȃ��j
- web.xml��FacesServlet�Ȃǂ�JSF�̐ݒ��������
- index.jsp�������āC�����index.xhtml�����
- �܂���JSF�̊Ǘ��r�[��������Ă݂�

## �͂��߂Ă�CDI1.0
- Project Structure��Module��CDI Facet��ǉ����Ȃ��Ă��ǂ��ijavaee-api-6.0.jar�Ɋ܂܂�Ă��邵�C�����ɒǉ�����̂�����j
  - �v��̂��ǂ����킩��Ȃ����ǁC./web/WEB-INF/beans.xml ��ǉ����Ƃ��i��������G���[�ɂȂ�������C�v��񂾂���j
- JSF�̊Ǘ��r�[����CDI�ɕς��Ă���
  - @ManagedBean �� @Model @Name(value="...") �ɕς��Ă����i@Model ����������C�����Ă���悤�œ����Ȃ��Ȃ����j
  - @EJB �� @Inject �ɕς���i@EJB�̂܂܂ł��g�����j
- **CDI���Ďg�������������̂��悭�킩���B(�L��֥`)**

## �͂��߂Ă�PrimFaces
- Project Structure��Module->Web->Add��PrimFaces��ǉ��i���C�u�����̃_�E�����[�h��� ./lib �ł�����j
  - �Ƃ��Ă���PrimFaces�̃o�[�W������ 3.4.1 �i���ꂪ�ŐV�Ȃ̂��ǂ����͒m��Ȃ��j
  - scope��compile�Őݒ肳���̂ŁC����͂��̂܂�
  - artifact��PrimFaces��������iFIX�{�^���������΁C����� ./WEB-INF/lib �ɕ��荞�܂��j
- �R���e���c��NetBeans�̃T���v���̊ۃp�N��


## ������
- �ɘ_�����ƁCJSF�g�����Ƃ��Ă�����web.xml�͗v��Ȃ�
  - FaceServlet���̂��̂̓A�m�e�[�V�����Ő錾���Ă���݂����ŁC��������web.xml�ɐ錾���Ȃ��Ă�������
    �i�ǂ����C/faces/* �Őݒ�ς݂��ۂ��j
  - �������Cwelcome-file�̐ݒ�͂������ق��������ifaces/index.xhtml�Ƃ��j
- persistence.xml�Ƀv���p�e�B�ݒ肵�Ă����ƁCJPA���ǂ��SQL�����������O�Ŋm�F�ł���
  - EclipseLink�̏ꍇ�́Ceclipselink.logging.level.sql��FINE�ɁCeclipselink.logging.parameters��true�ŗǂ�������SQL�����O�����
  - [EclipseLink/Examples/JPA/Logging](http://wiki.eclipse.org/EclipseLink/Examples/JPA/Logging)
- glassfish�ŃJ�o���b�W���ꍇ�́CCoverage Runner�� **JaCoCo** �ɂ��Ȃ��ƃ_��������


## Glassfish�̑����TomEE�ɍڂ��Ă݂�
- TomEE��Glassfish�ƈႢ�Chsqldb��OpenJPA���܂܂�Ă���̂ŁC���^�f�[�^�����̕ӂɍ��킹��
  - �f�[�^�\�[�X�́CMETA-INF/openejb.xml �ɋL�q���Ă����Cwar�t�@�C���Ɉꏏ�ɃA�[�J�C�u���邾���ŗǂ��i�y����j
  - persistence.xml�͂��̂܂܂��ƃX�L�[�}�𐶐����Ă���Ȃ��̂ŁCOpenJPA��EclipseLink��"ddl-generataion"�ɑ�������v���p�e�B
    (openjpa.jdbc.SynchronizeMappings) ��ݒ肵�Ă���
  - persistence.xml��EclipseLink��OpenJPA�̐ݒ�l�����݂��Ă��Ă����v�����B
  - Project Structure��JPA facet�ɂ��� "Default JPA provider" �ɑ債���Ӗ��͂Ȃ������i<No Default>�ł��������j

- TomEE��hsqldb�̎��̂́C$TOMEE_HOME/bin �ɂł������ۂ�
- TomEE���ƁCCoverage Runner�� **IDEA** �ł����C�������iSampling��������Ȃ��CTracing���ł���j

### Glassfish�Ɣ�ׂ�TomEE�̒n���ɗǂ��Ƃ���
- Setting->Application Servers �œo�^�����Ƃ��� Libraries ���[�����Ă���
- TomEE���ƈȉ��̃��C�u�������o�^�����
  - **javaee-api-6.0.5-tomcat.jar** �i����d�v�j
  - jsp-api.jar
  - servlet-api.jar
- Glassfish�̏ꍇ�C�����Ȃ�iJSF�Ƃ�CDI�Ƃ�JPA�Ƃ��̐S�Ȃ̂�����Ȃ��j
  - javax.ejb.jar
  - javax.servlet-api.jar
  - javax.servlet.jsp-api.jar

- ���Ȃ݂ɁCNetBeans�́u�c�[�����T�[�o�[�v�ɓo�^����Ă���Glassfish�̃��C�u�����͈ȉ��̒ʂ�B
  �iNetBeans�C�Ƃ�����JavaEE SDK��...���C�u���������������j
  - javax.servlet-api.jar
  - javax.servlet.jsp-api.jar
  - javax.persistence.jar
  - webservices-api-osgi.jar
  - javax.servlet.jsp.jstl-api.jar
  - jersey-core.jar
  - javax.security.jacc.jar
  - jaxm-api.jar
  - javax.security.auth.message.jar
  - javax.transaction.jar
  - javax.enterprise.deploy.jar
  - javax.annotation.jar
  - webservices-osgi.jar
  - javax.faces.jar
  - jaxb-osgi.jar
  - javax.resource.jar
  - javax.management.j2ee.jar
  - jaxb-api-osgi.jar
  - javax.ejb.jar
  - javax.el-api.jar
  - weld-osgi-bundle.jar
  - javax.mail.jar
  - javax.jms.jar
  - bean-validator.jar

�������������̂��Ƃ����ƁCIntelliJ��JavaEE�v���W�F�N�g���쐬�����Ƃ��ɁCProject Structure->Modules->Dependencies��Add->Library->Application Server Libraries��Glassfish���w�肵�Ă��C���낢�냉�C�u����������Ȃ��č���i�z���g�ɗ~�����̂́Cjavaee-api-6.0.jar�݂����ȑS������̂�j�B

�����䂤�Ӗ��ł�NetBeans�́u���J�b�e���v...�Ƃ������Y������

